var info = []
function getData(data) {
        info = data
}
layui.use(['laydate', 'element', 'laypage', 'layer', 'form'], function () {
    $ = layui.jquery;
    var form = layui.form(),
        lement = layui.element();
    laypage = layui.laypage;
    layer = layui.layer;
    var pageSize = 10
    var username = ""
    // var categoryno = ""
    // var category = ""
    var list = []
    getListData(1, true)
    form.on('submit(search)', function (data) {
        username = data.field.username
        // categoryno = data.field.categoryno
        // category = data.field.category
        getListData(1, true)
        return false;
    });
    function getListData(page, flag) {
        console.log('orderno: info.orderno,', info.orderno);
        
        var data = {
            orderno: localStorage.getItem("orderno"),
            level:localStorage.getItem("level"),
            email: localStorage.getItem("username"),
            pageSize: pageSize,
            page: page,
        }
        _post(findPress, data, function (result) {
            if (result.code == 1) {
                list = result.data.dataList
                console.log('list', list);
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
                            ${item.orderno}
                        </td>
                        <td>
                            ${item.name}
                        </td>
                        <td>
                            ${item.room}
                        </td>
                        <td>
                            ${item.roomtype}
                        </td>
                        <td>
                            ${item.price}
                        </td>
                        <td>
                            ${item.remark}
                        </td>
                    </tr>`
        });
        $tbody.html("")
        $tbody.append(html)
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