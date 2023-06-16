// 판매자/관리자 탭선택
$(".login-tab-btn").on("click", function(){
  $(".login-tab-btn").removeClass("selected");
  $(this).toggleClass("selected");
  // 판매자인지 관리자인지에 따라 url 다르게 보냄 how?
});
