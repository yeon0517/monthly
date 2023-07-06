import * as seller from '../module/seller.js';
import * as brand from '../module/brand.js';
import {findBrandFile} from "../module/brand.js";


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

//브랜드이미지띄워주기
showImageAll();

let $imgLong = $('.img-long>img');
let $imgSquare = $('.img-sq>img');

function showImageAll(){
  brand.findBrandFile('long',function(result){
  let fileName = result.brandFileUploadPath + '/'+result.brandFileUuid+'_'+result.brandFileName;
  $imgLong.attr('src','/brands/showImg?fileName='+fileName);
  $imgLong.attr('data-number',result.brandFileNumber);
  $imgLong.attr('data-name',result.brandFileName);
});
  brand.findBrandFile('square', function(result){
  let fileName = result.brandFileUploadPath + '/'+result.brandFileUuid+'_'+result.brandFileName;
  $imgSquare.attr('src','/brands/showImg?fileName='+fileName);
  $imgSquare.attr('data-number',result.brandFileNumber);
  $imgSquare.attr('data-name',result.brandFileName);
});
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
  let $brandImageLong = $('.img-long>img');
  let $brandImageSq = $('.img-sq>img');
  $brandImageLong.attr("src", '');
  $brandImageSq.attr("src", '');
//  + 원래사진 조회해서 가져오는것도 추가해야함
  showImageAll();
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

// let $imgLong = $('.img-long>img');
// let $imgSquare = $('.img-sq>img');

let $form = $('.brand-info-form');
// 브랜드 정보 + 브랜드 대표이미지 저장
$brandInfoSave.on('click',function (){
let form = $form[0];
let formData = new FormData(form);
  if($('#brand-name').val()==''|| $('#brand-contents').val()==''){
    alert('브랜드 정보를 먼저 입력 해 주세요');
  }else{

    //formData의 Key확인
      console.log("************************************************")
      for (let key of formData.keys()) {console.log(key);}
    // FormData의 value 확인
      for (let value of formData.values()) {console.log(value);}
      console.log("************************************************")
      //이미지파일이 두개가 아니면 저장을 막는다.
    if($imgLong.attr('src')==''||$imgSquare.attr('src')==''){
        alert("브랜드이미지를 등록 해 주세요");
    }else{
        brand.saveBrandInfo(formData);
        console.log('브랜드정보저장완료');
        alert("브랜드 정보가 저장되었습니다.");
  brand.findBrandInfo(
          function (result){
          $('#brand-name').val(result.brandName);
          $('#brand-contents').val(result.brandContents);
        }
    );
    }
  //브랜드정보업데이트하여 다시 보여주기
  }
/*  if($input.val()==''||$input2.val()==''){
    alert("브랜드이미지를 등록 해 주세요");
  }else{}*/
  showImageAll();
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

  //비밀번호 친구들
  let $cuPwMsg = $('.current-seller-password-msg');
  let $userPwMsg = $('.seller-password-msg');
  let $chPwMsg = $('.seller-password-check-msg');

  let $phoneMsg = $('.seller-phone-number-msg');
  let $emailMsg = $('.seller-email-msg');

// 비밀번호가 맞으면 회원정보 저장
$sellerInfoSave.on("click", function() {
  let sellerDto = {
    "sellerPassword" : $('#seller-password').val(),
    "sellerPostcode" : $('#postcode').val(),
    "sellerAddress1" : $('#address1').val(),
    "sellerAddress2" : $('#address2').val(),
    "sellerPhoneNumber" : $('#seller-phone-number').val(),
    "sellerEmail" : $('#seller-email').val(),
    "sellerCompanyRegisterNumber" : $('#seller-company-register-number').val(),
    "sellerContents" : $('#seller-contents').val()
  }
  console.log(sellerDto.sellerContents);

  let cuPwMsg = $cuPwMsg.text();
  let userPwMsg = $userPwMsg.text();
  let chPwMsg = $chPwMsg.text();
  let phoneMsg = $phoneMsg.text();
  let emailMsg = $emailMsg.text();
  console.log(cuPwMsg);

  if($('#current-seller-password').val()==''){
    alert("현재 비밀번호를 입력 해 주세요!");
  }else if(cuPwMsg.includes('않')){
    alert("현재 비밀번호를 확인 해 주세요!");
  //  현재 비밀번호가 맞으면 저장이 가능하다.
  //  ===============================================================
  }else{

    if($('#seller-phone-number').val()=='' || $('#seller-email').val()==''){
      //근데 필수정보 핸드폰, 이메일이 빈칸이면 저장이 불가능하다.
    alert('필수 정보를 입력 해 주세요!');
    return;
  }
  // 근데 정규표현식이 맞지 않으면 저장이 불가능하다.
  else if(userPwMsg.includes('불') || chPwMsg.includes('않') ||
      phoneMsg.includes('아닙') || emailMsg.includes('아닙')){
      alert('판매자정보를 다시 한 번 확인 해 주세요!');
      return;
  }else if($('#seller-password').val()==''){
    sellerDto["sellerPassword"]= $("#current-seller-password").val();
  }
      // 다 맞으면 저장한다.
  seller.modifySellerInfo(sellerDto);
  alert('판매자 정보가 수정되었습니다.');

// 새로 정보를 조회해서 띄워준다.
  seller.findSellerInfo(function(result){
    //비밀번호칸은 비워준다
    $('.pwGroup').val('');
    $('.pwGroupMsg').text('');
    //바뀐정보들을 꽂아넣는다
    $('#postcode').val(result.sellerPostcode);
    $('#address1').val(result.sellerAddress1);
    $('#address2').val(result.sellerAddress2);
    $('#seller-phone-number').val(result.sellerPhoneNumber);
    $('#seller-email').val(result.sellerEmail);
    $('#seller-company-register-number').val(result.sellerCompanyRegisterNumber);
    $('#seller-contents').val(result.sellerContents);
    console.log(result);
  });
  }
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
