layui.use(['laydate', 'element', 'laypage', 'layer', 'form'], function () {
    $ = layui.jquery;
    var form = layui.form(),
        lement = layui.element();
    laypage = layui.laypage;
    layer = layui.layer;
    var pageSize = 10
    var bookno = ""
    var bookname = ""
    var list = []
    getListData(1, true)
    form.on('submit(search)', function (data) {
        bookno = data.field.bookno
        bookname = data.field.bookname
        getListData(1, true)
        return false;
    });
    function getListData(page, flag) {
        var data = {
            pageSize: pageSize,
            page: page,
            bookname: bookname,
            bookno: bookno,
        }
        _post(findBook, data, function (result) {
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
                            ${item.bookno}
                        </td>
                        <td>
                            ${item.bookname}
                        </td>
                        <td>
                            ${item.press}
                        </td>
                        <td>
                            ${item.categoryno}
                        </td>
                        <td>
                            ${item.author}
                        </td>
                        <td>
                            ${item.num}
                        </td>
                        <td class="td-manage">
                            <a class="layui-btn layui-btn-xs acd edit" data-w='600' data-h='500' data-index='${index}' data-url='edit.html' data-title='编辑'"
                                lay-event="edit">编辑</a>
                            <a class="layui-btn layui-btn-xs layui-btn-danger acds del"   data-index='${index}'  
                                lay-event="edit">删除</a>
                            <a  class="layui-btn layui-btn-xs  dels"  data-index='${index}'  
                                lay-event="edit">借阅</a>
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
        if(localStorage.getItem("ulevel")==0){
          // document.getElementsByClassName("dels").style.display="none";
          var a = document.getElementsByClassName('acd');
          for(var i = 0 ; i < a.length;i++){
              a[i].style.display="none";
          }
          var as = document.getElementsByClassName('acds');
          for(var i = 0 ; i < as.length;i++){
              as[i].style.display="none";
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
            x_admin_show(title, url, w, h, data);
        }
        $('.del').on('click', function () {
            var index = $(this).attr('data-index')

            layer.confirm('确认要删除吗？', function () {
                _post(deleteBook, { id: list[index].id }, function (result) {
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
        $('.dels').on('click', function () {
          var index = $(this).attr('data-index')

          layer.confirm('确认要借阅吗？', function () {
              _post(lend, { bid: list[index].id,id:localStorage.getItem("uid") }, function (result) {
                console.log("resultresultresult",result)
                  if (result.code == 1) {
                      layer.msg('借阅成功', {
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