//验证用户是否已被注册
$("#username").blur(function(){
	HrManager.sendAjaxPost("/findUsersName",{username:$("#username").val()},function(data){
		if (data.resultCode!=200) {
			/* 不带图标提示框 */	     
	        YDUI.dialog.toast(data.resultMsg, 'none', 1000);
	        $("#username")[0].focus();
	        return false;
		}
	})
});
//验证两次密码是否一致
$("#password2").blur(function(){
	if ($("#password2").val()!=$("#password").val()) {
		/* 不带图标提示框 */
        YDUI.dialog.toast("两次密码不一致", 'none', 1000);
        $("#password")[0].focus();
        return false;
	}
});

//获取短信验证码
$("#J_GetCode").click(function () {
    /*this.preventDefault();*/
    checkPhone();
    //短信验证码
    var dialog = YDUI.dialog;
    var $getCode = $('#J_GetCode');
    // 定义参数
    $getCode.sendCode({
        disClass: 'btn-disabled', // 禁用按钮样式【必填】
        secs: 60, // 倒计时时长 [可选，默认：60秒]
        run: false,// 是否初始化自动运行 [可选，默认：false]
        runStr: '{%s}秒后重新获取',// 倒计时显示文本 [可选，默认：58秒后重新获取]
        resetStr: '重新获取验证码'// 倒计时结束后按钮显示文本 [可选，默认：重新获取验证码]
    });
    var $this = $(this);
    dialog.loading.open('发送中...');
    // ajax 成功发送验证码后调用【start】
    setTimeout(function () { //模拟ajax发送
        dialog.loading.close();
        $this.sendCode('start');
    }, 800);
    HrManager.sendAjaxPost("/proving",{phone1:$("#phone").val()},function(data){
        if (data.resultCode!=200) {
            /* 不带图标提示框 */
            YDUI.dialog.toast(data.data, 'none', 2000);
            return false;
        }else{
            dialog.toast('已发送', 'success', 1000);
            //把验证码保存在页面的隐藏域
            $("#proving").val(data.data);
        }
    });
    //输入验证码
    $("#proving2").blur(function(){
        if($("#proving2").val()!=$("#proving").val()){
            /* 不带图标提示框 */
            YDUI.dialog.toast("验证码输入错误", 'none', 1000);
            return false;
        }
    });
});
//点击注册的时候判断所有验证
$("#reg").click(function () {
    if(!$("#username").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("用户名不能为空", 'none', 1000);
        return false;
    }
    if(!$("#password").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("密码不能为空", 'none', 1000);
        return false;
    }
    if(!$("#password2").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("确认密码不能为空", 'none', 1000);
        return false;
    }
    if(!$("#phone").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("手机号码不能为空", 'none', 1000);
        return false;
    }
    checkPhone();
    if(!$("#proving2").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("验证码不能为空", 'none', 1000);
        return false;
    }
    if(!$("#accountnumber").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("支付宝账号不能为空", 'none', 1000);
        return false;
    }
    if(!$("#higherlevelId").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("邀请码不能为空", 'none', 1000);
        return false;
    }
    //提交表单
    $("#regform").attr("action","/reg");
    $("#regform").attr("method","post");
    $("#regform").submit();
    //注册成功之后清除页面保存的验证码
});

//验证手机号的方法
function checkPhone() {
    ////验证手机号
    var reg = /^1[3,4,5,7,8]\d{9}$/;
    if (reg.test($("#phone").val()) != true){
        /* 不带图标提示框 */
        YDUI.dialog.toast("请输入正确的手机号", 'none', 1000);
        $("#phone")[0].focus();
        return false;
    }
}