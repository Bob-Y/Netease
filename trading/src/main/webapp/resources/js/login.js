$(function() {
    // 登录验证的controller url
    var loginUrl = '';
    // 用户类型，通过登录验证返回，买家为 1
    var usertype = getQueryString('usertype');

    $('#submit').click(function() {
        var userName = $('#username').val();
        var password = $('#psw').val();

        // 访问后台进行登录验证
        $.ajax({
            url : loginUrl,
            async : false,
            cache : false,
            type : "post",
            dataType : 'json',
            data : {
                userName : userName,
                password : password,
            },
            success : function(data) {
                if (data.success) {
                    $.toast('登录成功！');
                    if (usertype == 1) {
                        // 跳转买家页面
                        window.location.href = '';
                    } else {
                        // 跳转卖家页面
                        window.location.href = '/o2o/shopadmin/shoplist';
                    }
                } else {
                    $.toast('登录失败！' + data.errMsg);
                }
            }
        });
    });
});