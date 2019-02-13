/**
 * Created by linziyu on 2019/2/9.
 */

// 登录处理
layui.use(['form','layer','jquery'], function () {


    var form = layui.form;
    var $ = layui.jquery;

    form.on('submit(login)',function (data) {
            var username = $('#username').val();
            var password = $('#password').val();
            // layer.msg(username);
        $.ajax({

            url:"/login",
            data:{
                "username": username,
                "password": password
            },
            dataType:"json",
            type:'post',
            async:false,
            success:function (data) {
                if (data.code == 401){
                    layer.alert("用户名字或密码错误");
                }
                if(data.code == 200){
                    window.location.href = "/";
                }

            }
        });

    })

});


