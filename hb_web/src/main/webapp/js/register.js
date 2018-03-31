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
//验证手机号
$("#phone").blur(function(){
    var reg = /^1[3,4,5,7,8]\d{9}$/;
    if (reg.test($("#phone").val()) != true){
		/* 不带图标提示框 */
        YDUI.dialog.toast("请输入正确的手机号", 'none', 1000);
        $("#phone")[0].focus();
        return false;
	}
});