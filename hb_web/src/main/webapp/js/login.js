var flag=false;
$('#mpanel1').slideVerify({
    type : 1,		//类型
    vOffset : 5,	//误差量，根据需求自行调整
    barSize : {
        width : '90%',
        height : '40px',
    },
    ready : function() {
    },
    success : function() {
        flag=true;
        //......后续操作
    },
    error : function() {
        flag=false;
    }

});

//点击登录的时候
$("#login").click(function(){
    if(!$("#username").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("用户名不能为空", 'none', 1000);
        $("#username")[0].focus();
        return false;
    }
    if(!$("#password").val()){
        /* 不带图标提示框 */
        YDUI.dialog.toast("密码不能为空", 'none', 1000);
        $("#password")[0].focus();
        return false;
    }
    if(!flag){
        /* 不带图标提示框 */
        YDUI.dialog.toast("验证码错误", 'none', 1000);
        return false;
    }
    var username = $("#username").val();
    var password = $("#password").val();
    var url = "/login";
    HrManager.sendAjaxPost(url,{username:username,password:password},function (pdata) {
        if (pdata.resultCode==200) {
             window.location.href = "/toindex";
        }else{
            //不带图标提示框
            alert("账号或密码错误");

            return false;
        }
    });
});