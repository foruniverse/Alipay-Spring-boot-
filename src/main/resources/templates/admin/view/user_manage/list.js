layui.use(['laydate', 'element', 'laypage', 'layer', 'form'], function () {
    $ = layui.jquery;
    var form = layui.form(),
        lement = layui.element();
    laypage = layui.laypage;
    layer = layui.layer;
    var pageSize = 10
    // var contacts = ""
    // var mobile = ""
    var username = ""
    var name = ""
    var bookname = ""
    var list = []
    getListData(1, true)
    form.on('submit(search)', function (data) {
        // contacts = data.field.contacts
        // mobile = data.field.mobile
        name = data.field.name
        bookname = data.field.bookname
        getListData(1, true)
        return false;
    });
    function getListData(page, flag) {
        var data = {
            name:name,
            pageSize: pageSize,
            page: page,
            level:localStorage.getItem("level")
        }
        _post(findUser, data, function (result) {
            if (result.code == 1) {
                list = result.data.dataList
                setListData(result.data.dataList)
                if (flag) {
                    var count = result.data.count
                    var pages = 0
                    var num1 = parseInt(count / pageSize)
                    var num2 = count % pageSize
                    if (num2 > 0) {
                        num2 = 1
                    }
                    pages = num1 + num2
                    initPage(pages)
                }
            } else {
            }
        });
    }

    function initPage(pages) {
        laypage({
            cont: 'page',
            pages: pages,
            first: 1,
            last: pages,
            jump: function (obj, first) {
                if (!first) {
                    getListData(obj.curr)
                }
            }
        });
    }
    function setListData(dataList) {
        var $tbody = $('.dataList tbody')
        var html = ""
        dataList.forEach((item, index) => {
            html += ` <tr>
                        <td>
                            ${item.email}
                        </td>
                        <td>
                            ${item.name}
                        </td>
                        <td>
                            ${item.age}
                        </td>
                        <td>
                            ${item.sex}
                        </td>
                        <td>
                            ${item.zfb}
                        </td>
                        <td>
                            ${item.level==1?"普通用户":"管理员"}
                        </td>
                        <td>
                            ${item.createtime}
                        </td>
                        <td class="td-manage">
                            <a class="layui-btn layui-btn-xs acd edit" data-w='600' data-h='500' data-index='${index}' data-url='edit.html' data-title='编辑'"
                                lay-event="edit">编辑</a>
                                <a class="layui-btn layui-btn-xs layui-btn-danger del"  data-index='${index}'  
                                lay-event="edit">删除</a>
                        </td>
                    </tr>`
        });
        $tbody.html("")
        $tbody.append(html)
        if(localStorage.getItem("ulevel")==1){
          // document.getElementsByClassName("dels").style.display="none";
          var a = document.getElementsByClassName('dels');
          for(var i = 0 ; i < a.length;i++){
              a[i].style.display="none";
          }
        }
        $('.edit').on('click', function () {
            var title = $(this).attr('data-title')
            var url = $(this).attr('data-url')
            var w = $(this).attr('data-w')
            var h = $(this).attr('data-h')
            var index = $(this).attr('data-index')
            edit(title, url, w, h, index)
        })
        function edit(title, url, w, h, index) {
            var data = list[index]
            if(localStorage.getItem("level")=="2"){
                layer.msg('只有超级管理员才能编辑');
                return
            }
            x_admin_show(title, url, w, h, data);
        }
        $('.del').on('click', function () {
            var index = $(this).attr('data-index')

            layer.confirm('确认要删除吗？', function () {
                _post(deleteBookCategory, { id: list[index].id }, function (result) {
                    if (result.code == 1) {
                        layer.msg('删除成功', {
                            icon: 1
                        });
                        setTimeout(() => {
                            location.reload()
                        }, 500);
                    } else {
                        toast(result.message)
                    }
                });
            });
        })
    }
});
function add(title, url, w, h) {
    x_admin_show(title, url, w, h);
}