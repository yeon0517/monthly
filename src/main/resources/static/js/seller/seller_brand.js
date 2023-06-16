//헤더에 active 색추가
let $head = $('#seller-brand');
$(".header-nav-item>a").removeClass("header-active");
$head.addClass("header-active");


// 브랜드이미지 미리보기

let $input = $('#post-image');
console.log($input);

let $brandImage = $('.brand-image>img');
console.log($brandImage);

// file change이벤트로 미리보기 갱신
$input.on('change', function () {
  let file = this.files[0];
  console.log(file);
  appendImg(file);
});

// 이미지 미리보기 처리 함수
function appendImg(file){
  let src = URL.createObjectURL(file);
  $brandImage.attr("src", src);
}