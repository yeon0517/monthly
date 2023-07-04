

function sample6_execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 각 주소의 노출 규칙에 따라 주소를 조합한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var addr = ""; // 주소 변수
      var extraAddr = ""; // 참고항목 변수

      //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
      if (data.userSelectedType === "R") {
        // 사용자가 도로명 주소를 선택했을 경우
        addr = data.roadAddress;
      } else {
        // 사용자가 지번 주소를 선택했을 경우(J)
        addr = data.jibunAddress;
      }

      // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
      if (data.userSelectedType === "R") {
        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
          extraAddr += data.bname;
        }
        // 건물명이 있고, 공동주택일 경우 추가한다.
        if (data.buildingName !== "" && data.apartment === "Y") {
          extraAddr +=
            extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
        }
        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
        if (extraAddr !== "") {
          extraAddr = " (" + extraAddr + ")";
        }
        // 조합된 참고항목을 해당 필드에 넣는다.
        // document.getElementById("address2").value = extraAddr;
      } else {
        // document.getElementById("address2").value = "";
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      document.getElementById("deliveryPostcode").value = data.zonecode;
      document.getElementById("deliveryAddress1").value = addr;
      // 커서를 상세주소 필드로 이동한다.
      document.getElementById("deliveryAddress2").focus();
    },
  }).open();
}


const checkbox = document.querySelector('.check');
const payButton = document.querySelector('.pay');

checkbox.addEventListener('change', function() {

  if (checkbox.checked) {
    payButton.disabled = false;
  } else {
    payButton.disabled = true;
  }
});

$('#new').on('click',function (){
  $('#deliveryPostcode').val("");
  $('#deliveryAddress1').val("");
  $('#deliveryAddress2').val("");
});

$('#same').on('click',function (){
  window.location.reload();
});


document.cookie="safeCookie1=foo;SameSite=Lax";
document.cookie="safeCookie2=foo";
document.cookie="crossCookie=bar;SameSite=None;Secure";

let uuid = self.crypto.randomUUID();
let userEmail = $('#userEmail').val();
let price = $('#inputPrice').val();
let userName = $('#userName').val();
let productTitle = $('.productTitle').val();
let userPhoneNumber = $('#userPhoneNumber').val();
let postAddress = $('#postAddress').val();
let proDate = $('.productRegisterDate').val();

$('.pay').on('click',function (){
  var IMP = window.IMP;
  IMP.init('imp25167604');
  IMP.request_pay({
    pg: "kakaopay",
    pay_method: "card",
    merchant_uid: "monthly"+"_"+proDate +"_"+uuid, // 상점에서 관리하는 주문 번호
    name : productTitle,
    amount : price, // 빌링키 발급과 함께 1,004원 결제승인을 시도합니다.
    customer_uid : uuid, // 필수 입력
    buyer_email : userEmail,
    buyer_name : userName,
    buyer_tel : userPhoneNumber,
    buyer_postcode: postAddress,
    m_redirect_url : "https://yourservice.com/mobile/billing/landing" //모바일에서 빌링키 발급 후 이동할 URL
  }, function(rsp) {
    if ( rsp.success ) {
      console.log(rsp);
      console.log(rsp.success);
      console.log(rsp.imp_uid );
      console.log(rsp.card_name);
      console.log(rsp.card_number);
      console.log(rsp.customer_id);
      console.log(rsp.merchant_uid);
      console.log(rsp.paid_amount);
      console.log(rsp.pg_type);
      $('#cardNumber').val(rsp.card_number);

      let obj = {
        merchantId : rsp.merchant_uid,
        customerId : uuid,
        impUid : rsp.imp_uid,
        cardName: rsp.card_name,
        cardNumber: rsp.card_number,
        paidAmount: rsp.paid_amount,
        pgType: rsp.pg_type
      }

      $.ajax({
        url : '/orders/payInfo',
        type: 'post',
        data: JSON.stringify(obj),
        dataType:"json",
        contentType : 'application/json; charset=utf-8',
        success : function (result){
          console.log(result);
          alert("구독 완료");
        }
      });
      alert('결제 성공');
      $("form").submit();
    } else {
      alert('결제 실패');
    }


  });

});










