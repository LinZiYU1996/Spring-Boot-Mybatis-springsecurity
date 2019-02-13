/**
 * Created by linziyu on 2019/2/7.
 */


// 注册处理
layui.use(['form','jquery','layer'], function () {
    var form   = layui.form;
    var $      = layui.jquery;
    var layer  = layui.layer;
    //添加表单失焦事件
    //验证表单
    var check = "";//全局参数 用于提交表单时的校验
    $('#username').blur(function() {
        var name = $(this).val();

        $.ajax({
            url:'/checkNameIsExistOrNot',//用户名框失去焦点是进行ajax请求 检验用户名是否重复了
            type:'post',
            dataType:'json',
            data:{username:name},
            //验证用户名是否可用
            success:function(data){
                if (data.code == 200) {
                    $('#ri').removeAttr('hidden');
                    $('#wr').attr('hidden','hidden');
                    check="OK";

                } else {
                    check = "当前用户名已被占用";
                    $('#wr').removeAttr('hidden');
                    $('#ri').attr('hidden','hidden');
                    layer.msg('当前用户名已被占用! ');

                }

            }
        })

    });

    // you code ...
    // 为密码添加正则验证
    $('#password').blur(function() {
        var reg = /^[\w]{1,12}$/;
        if(!($('#password').val().match(reg))){
            //layer.msg('请输入合法密码');
            $('#pwr').removeAttr('hidden');
            $('#pri').attr('hidden','hidden');
            layer.msg('请输入合法密码');
        }else {
            $('#pri').removeAttr('hidden');
            $('#pwr').attr('hidden','hidden');
        }
    });

    //验证两次密码是否一致
    $('#rpwd').blur(function() {
        if($('#password').val() != $('#rpwd').val()){
            $('#rpwr').removeAttr('hidden');
            $('#rpri').attr('hidden','hidden');
            layer.msg('两次输入密码不一致!');
        }else {
            $('#rpri').removeAttr('hidden');
            $('#rpwr').attr('hidden','hidden');
        };
    });

    //
    //添加表单监听事件,提交注册信息
    form.on('submit(sub)', function(data) {
        if(check != "OK"){
            layer.alert("该用户名已经被使用了");//提交前的校验
            return;
        }
        $.ajax({
            url:'/register',
            type:'post',
            dataType:'json',
            data:{
                username:$('#username').val(),
                password:$('#password').val()
            },
            success:function(data){
                if (data.code == 200 ) {
                    layer.alert('注册成功');
                }else {
                    layer.msg('注册失败');
                }
            }
        });
        //防止页面跳转
        return false;
    });

});
