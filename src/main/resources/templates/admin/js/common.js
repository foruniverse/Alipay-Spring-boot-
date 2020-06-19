var layer = layui.use(['form'],
  function () {
    $ = layui.jquery;
    return layui.layer;
  });
var onlineIp = "http://127.0.0.1:8585";
//var onlineIp = "http://styhsk666.zicp.io"
var ip = onlineIp
var url = ip + "/back/";
// var login = url + "backLogin"
var login = url + "login"
var addZUser = url + "addZUser"
var regist = url + "regist"
var updatePassword = url + "updatePassword"

var uploadPhoto = url+"uploadPhoto"

var findZUser = url + "findZUser"

var getCode = url + "getCode"

var findBookCategory = url + 'findOrder'
var addBookCategory = url + 'addZUser'
var updateBookCategory = url + 'updateZUser'
var lend = url + 'lend'
var deleteBookCategory = url + 'deleteZUser'

var findPress = url + "findOrderDetail"
var addPress = url + 'addPress'
var updatePress = url + 'updatePress'
var deletePress = url + 'deletePress'


var findBook = url + "findBook"
var addBook = url + 'addBook'
var updateBook = url + 'updateBook'
var deleteBook = url + 'deleteBook'

var findStock = url + "findStock"
var addStock = url + 'addStock'
var updateStock = url + 'updateStock'
var deleteStock = url + 'deleteStock'

var findPurchase = url + "findPurchase"
var addPurchase = url + 'addPurchase'
var updatePurchase = url + 'updatePurchase'
var deletePurchase = url + 'deletePurchase'

var findOutbound = url + "findOutbound"
var addOutbound = url + 'addOutbound'
var updateOutbound = url + 'updateOutbound'
var deleteOutbound = url + 'deleteOutbound'



function _get(url, data, callback, isLoading, content) {
  data.token = localStorage.getItem("token");
  var loadingObj;
  $.ajax({
    type: "GET",
    contentType: 'application/x-www-form-urlencoded',
    dataType: "json",
    corssDomain: true,
    url: url,
    data: data,
    beforeSend: function () {
      if (isLoading) {
      };
    },
    success: function (data) {
      typeof callback == 'function' && callback(data);
    },
    error: function (data) {
    },
    complete: function () {
      if (isLoading) {
      };
    }
  });
}
function _post(url, data, callback, isLoading, content) {
  data.token = localStorage.getItem("token"); //
  var loadingObj;
  $.ajax({
    type: "POST",
    contentType: 'application/x-www-form-urlencoded',
    dataType: "json",
    corssDomain: true,
    url: url,
    data: data,
    beforeSend: function () {
      if (isLoading) {
      };
    },
    success: function (data) {
      intercept(data)
      typeof callback == 'function' && callback(data);
    },
    error: function (data) {
    },
    complete: function () {
      if (isLoading) {
      };
    }
  });
}
function _upload(data, callback) {
  $.ajax({
    url: uploadPhoto,
    type: 'post',
    contentType: false,
    processData: false,
    dataType: 'json',
    data: data,
    xhrFields: {
      withCredentials: true
    },
    success: function (data) {
      typeof callback == 'function' && callback(data);
    }
  });
}
function intercept(data) {
  if (data.message == "token已过期") {
    localStorage.removeItem('token')
    if (window.location.host) {
      var url = window.location.host + "/cp/M/login.html"
      window.location.href = url
    }
  }
}
function showLoading() {
  layer.load(1, {
    shade: [0.7, '#000'],
  });
}
function hideLoading() {
  layer.closeAll('loading')
}
function toast(content) {
  layer.msg(content)
}

