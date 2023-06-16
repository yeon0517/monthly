
// 메뉴바 누르면 색상변경
$(".header-nav-item").on("click", function () {
  console.log(this);
  let $tagA = $(this).children();
  console.log($tagA);
  $(".header-nav-item>a").removeClass("header-active");
  $tagA.toggleClass("header-active");
});