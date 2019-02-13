/**
 * Created by linziyu on 2019/2/11.
 */
/**
 * Created by linziyu on 2019/2/6.
 */

// 用于分页展示用户信息


layui.use(["form","table","element"], function(){
    var $ = layui.jquery;
    var element = layui.element;
    var table = layui.table;
    var form = layui.form;

    $("#display-users").click(function () {
        table.render({
            elem: '#test'
            ,url:'/getAllUser'
            ,toolbar: '#toolbarDemo'
            ,title: '用户数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'ID'}
                ,{field:'username', title:'用户名'}

                ,{field:'password', title:'密码'}
                ,{field:'role', title:'角色'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:500}
            ]]
            ,page: true
            ,limit:5
        });
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        alert(checkStatus+'asasasas');
        switch(obj.event){
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选': '未全选');
                break;
        }
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;//获取User数据
        var role = data.role;

        if(obj.event === 'del'){//对应删除事件
            layer.confirm('真的删除该用户吗', function(index){
                $.ajax({
                    url:'/deleteUserById',
                    type:'post',
                    dataType:'json',
                    data:{
                        id:data.id,
                        role:data.role
                    },
                    success:function(data){
                        if (data.code == 200 ) {
                            layer.alert("删除成功！",function(){
                                window.parent.location.reload();//刷新父页面
                                parent.layer.close(index);//关闭弹出层
                            });
                        }else if(data.code == 500){
                            layer.alert("您不是管理员，没有权限进行该操作");
                        } else if (data.code == 501){
                            layer.alert("您打算删除的用户是其它管理员，您没有权限进行此操作");
                        }
                    }
                });
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.open({
                type: 2,//坑
                title:'查看用户',
                area: ['auto','auto'],
                content:'/change_user_role',
                success:function (layero, index) {
                    var body = layui.layer.getChildFrame('body', index);
                    // 获取子页面的iframe
                    var iframe = window['layui-layer-iframe' + index];
                    // 向子页面的全局函数child传参
                    // iframe.get(data.name);
                    body.find("#id").val(data.id);
                    form.render();
                }
            });
        }
        else if (obj.event === 'getInfo'){
            layer.open({
                type: 2,//坑
                title:'查看用户',
                area: ['500px', '500px'],
                content:'/display_user_info',
                success:function (layero, index) {
                    var body = layui.layer.getChildFrame('body', index);
                    // 获取子页面的iframe
                    var iframe = window['layui-layer-iframe' + index];
                    // 向子页面的全局函数child传参
                    // iframe.get(data.name);
                    body.find("#username").val(data.username);
                    body.find("#password").val(data.password);
                    body.find("#id").val(data.id);
                    body.find("#role").val(data.role);
                    form.render();
                }
            });
        }
    });
});