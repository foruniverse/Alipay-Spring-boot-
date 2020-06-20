var userInfo = JSON.parse(localStorage.getItem('userInfo'))
if (userInfo == undefined) {
  window.location.href = './login.html'
}
function exitLogin() {
  localStorage.removeItem('userInfo')
  localStorage.removeItem('token')
  toast('退出成功')
  setTimeout(() => {
    window.location.href = './login.html'
  }, 300);
}

