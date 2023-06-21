// 판매자/관리자 탭선택
let $section = $('#select-login'); //form태그

$(".login-tab-btn").on("click", function(){
  $(".login-tab-btn").removeClass("selected");
  $(this).toggleClass("selected");

//  판매자인지 관리자인지에 따라 form action 다르게 보냄 >
//  selected 클래스를 가진 요소의 data-who 속성을 가져온다
//  data-who 가 seller 면 $section.attr("action","seller/login")으로 바꿔준다

  let who = $(this).children().attr('data-who');
  console.log(who);
    let $id = $('#select-id');
    let $password = $('#select-password');
  if(who=='admin'){
    $section.attr("action", "/admin/login");
    console.log($id);

    $id.attr("name","adminId");
    $password.attr("name","adminPassword");
    console.log($id.attr("name"));
    console.log($password.attr("name"));
  }else{
    $section.attr("action", "/seller/login")
    $id.attr("name","sellerId");
    $password.attr("name","sellerPassword");
  }
  console.log($section.attr("action"));

});


