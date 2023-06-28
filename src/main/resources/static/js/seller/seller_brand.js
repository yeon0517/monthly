import * as seller from '../module/seller.js';
import * as brand from '../module/brand.js';


//헤더에 active 색추가
let $head = $('#seller-brand');
$(".header-nav-item>a").removeClass("header-active");
$head.addClass("header-active");

//=====================================================
//브랜드 섹션
// 브랜드이름 존재하면 수정불가
let $brandName = $('#brand-name');
console.log($brandName);
console.log($brandName.val());
if($brandName.val()==''){
  $brandName.removeAttr("readonly");
}

// 브랜드이미지 미리보기
let $input = $('#post-image');
console.log($input);
let $input2 = $('#post-image2');
// let $brandImage = $('.brand-image>img');
// console.log($brandImage);

// file change이벤트로 미리보기 갱신
$input.on('change', function () {
  let file = this.files[0];
  let $brandImageLong = $('.img-long>img');
  let src = URL.createObjectURL(file);
  $brandImageLong.attr("src", src);
  console.log(file);
//   appendImg(file);
});

$input2.on('change', function (){
  let file = this.files[0];
  let $brandImageSq = $('.img-sq>img');
  let src = URL.createObjectURL(file);
  $brandImageSq.attr("src", src);
  // appendImg(file);
});

// 이미지 미리보기 처리 함수
// function appendImg(file){
//   let src = URL.createObjectURL(file);
//   $brandImage.attr("src", src);
// }

let $brandInfoSave = $('.brand-info-btn>.save-btn');
console.log($brandInfoSave);
let $brandInfoCancel = $('.brand-info-btn>.cancel-btn');


// 취소 버튼을 누르면 원래 정보를 조회해서 가져옴
$brandInfoCancel.on('click', function(){
  brand.findBrandInfo(function (result){
    $('#brand-name').val(result.brandName);
    $('#brand-contents').val(result.brandContents);
  });
//  + 원래사진 조회해서 가져오는것도 추가해야함
//  brand.showBrandFile(callback)
  alert('브랜드 정보 수정을 취소합니다.');
});



// 브랜드 정보 저장
//   $brandInfoSave.on('click', function(){
  // console.log($('#brand-contents').val());
    // let brandDto = {
      // "brandName" : $('#brand-name').val(),
//       "brandContents" : $('#brand-contents').val()
//     }
//   console.log(brandDto);
//
//   alert('브랜드 정보가 저장되었습니다.');
//
//   brand.findBrandInfo(
//           function (result){
//           $('#brand-name').val(result.brandName);
//           $('#brand-contents').val(result.brandContents);
//         }
//     );
// });

let $form = $('.brand-info-form');
// 브랜드 정보 + 브랜드 대표이미지 저장
$brandInfoSave.on('click',function (){
let form = $form[0];
let formData = new FormData(form);

//formData의 Key확인
  console.log("************************************************")
  for (let key of formData.keys()) {console.log(key);}
// FormData의 value 확인
  for (let value of formData.values()) {console.log(value);}
  console.log("************************************************")
  //이미지파일이 두개가 아니면 저장을 막는다.
  if($input.val()==''||$input2.val()==''){
    alert("브랜드이미지를 등록 해 주세요");
  }else{
  brand.saveBrandInfo(formData);
  //브랜드정보업데이트하여 다시 보여주기
  brand.findBrandInfo(
          function (result){
          $('#brand-name').val(result.brandName);
          $('#brand-contents').val(result.brandContents);
        }
    );
  console.log('브랜드정보저장완료');
  alert("브랜드 정보가 저장되었습니다.");
  }
});




//===========================================================================
// 판매자 섹션

// 사업자등록번호가 존재하면 수정불가
let $companyNumber = $('#seller-company-register-number');
if($companyNumber.val()==''){
  $companyNumber.removeAttr("readonly");
}
// 판매자 정보 수정
let $sellerInfoSave= $('.seller-info-btn>.save-btn');
let $sellerInfoCancel = $('.seller-info-btn>.cancel-btn');

console.log($sellerInfoSave);
console.log($sellerInfoCancel);

let sellerDto = {
  "sellerPassword" : $('#seller-password').val(),
  "sellerPostcode" : $('#postcode').val(),
  "sellerAddress1" : $('#address1').val(),
  "sellerAddress2" : $('#address2').val(),
  "sellerPhoneNumber" : $('#seller-phone-number').val(),
  "sellerEmail" : $('#seller-email').val(),
  "sellerCompanyRegisterNumber" : $('#seller-company-register-number').val(),
  "sellerContents" : $('#seller-contents').text()
}



  let $cuPwMsg = $('.current-seller-password-msg');
  let $userPwMsg = $('.seller-password-msg');
  let $chPwMsg = $('.seller-password-check-msg');

// 비밀번호가 맞으면 회원정보 저장
$sellerInfoSave.on("click", function() {
//   let cuPwMsg = $cuPwMsg.text();
//   let userPwMsg = $userPwMsg.text();
//   let chPwMsg = $chPwMsg.text();
//
  alert("누른다!");

  // if($('#seller-password').val()==''){
  //   alert("현재 비밀번호를 입력 해 주세요!");
  // }else if(cuPwMsg.includes('않')){
  //   alert("현재 비밀번호를 확인 해 주세요!")
  // }else if(!cuPwMsg.includes('않')&&
  //     !userPwMsg.includes('불')&&
  //     !chPwMsg.includes('않')){
  //   // seller.modifySellerInfo(sellerDto);
  //   alert("저장되었습니다.");
  // }else{
  //   alert('회원정보를 다시 확인해 주세요');
  // }
// seller.findSellerInfo(function(result){
//     $('.pwGroup').val('');
//     $('.pwGroupMsg').text('');
//     $('#postcode').val(result.sellerPostcode);
//     $('#address1').val(result.sellerAddress1);
//     $('#address2').val(result.sellerAddress2);
//     $('#seller-phone-number').val(result.sellerPhoneNumber);
//     $('#seller-email').val(result.sellerEmail);
//     $('#seller-company-register-number').val(result.sellerCompanyRegisterNumber);
//     $('#seller-contents').val(result.sellerContents);
//         console.log(result);
// }
});

// 취소버튼을 누르면 원래 정보를 조회해서 가져옴
$sellerInfoCancel.on('click',function (){
  console.log("click")
  seller.findSellerInfo(function(result){
    $('.pwGroup').val('');
    $('.pwGroupMsg').text('');
    $('#postcode').val(result.sellerPostcode);
    $('#address1').val(result.sellerAddress1);
    $('#address2').val(result.sellerAddress2);
    $('#seller-phone-number').val(result.sellerPhoneNumber);
    $('#seller-email').val(result.sellerEmail);
    $('#seller-company-register-number').val(result.sellerCompanyRegisterNumber);
    $('#seller-contents').val(result.sellerContents);
        console.log(result);
  });
  alert('판매자정보 수정이 취소되었습니다.');
});
