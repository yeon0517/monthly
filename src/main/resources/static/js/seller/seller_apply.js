// 판매자신청페이지!!!
// import * as seller from '../module/seller.js';
// 아이디인풋칸
let $sellerIdInput = $('#seller-id');
// 아이디 메세지 띄울곳
let $sellerIdMsg = $('.seller-id-msg');

// 아이디 정규표현식
var idReg = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z0-9]{4,8}$/;
function checkIdValidity() {
    if (idReg.test($sellerIdInput.val())) {
        $sellerIdMsg.text('사용가능한 아이디입니다.');
        $sellerIdMsg.css("color", "#8eb4c8");
    } else {
        $sellerIdMsg.html('사용 불가능한 아이디입니다. <br>영어, 숫자를 포함하여 4글자 이상 작성하세요!');
        $sellerIdMsg.css("color","#c88e8e");
    }
}

// 아이디 중복체크
$sellerIdInput.on('blur', function() {
    if ($(this).val() == '') {
        $sellerIdMsg.text('아이디를 입력하세요');
        $sellerIdMsg.css("color","#c88e8e");
    } else {
        let id = $sellerIdInput.val();
        console.log(id);

        $.ajax({
            url: '/sellers/checkId',
            type: 'get',
            data: {sellerId: id},
            success: function (result) {
                if (result == 1) {
                    $sellerIdMsg.text('중복된 아이디 입니다.')
                    $sellerIdMsg.css("color","#c88e8e");
                } else {
                    checkIdValidity();
                }
            },
            error: function (a, b, c) {
                console.log(c);
            }
        });
    }
});

// ======비밀번호============
// 비밀번호 인풋칸

let $currentPwInput = $('#current-seller-password');
let $sellerPwInput = $('#seller-password');
let $checkPwInput = $('#seller-password-check')

// 메세지 띄울 곳들
let $cuPwMsg = $('.current-seller-password-msg');
let $userPwMsg = $('.seller-password-msg');
let $chPwMsg = $('.seller-password-check-msg');

// 현재비밀번호 맞는지 확인 ajax
$currentPwInput.on('blur', function(){
  if($(this).val()==''){
    $cuPwMsg.text('비밀번호를 입력하세요');
	}else{
    // 		let pw = $currentPwInput.val();
    // 		$.ajax({
      // 			url : '/user/checkPwOk.us',
      // 			type : 'get',
      // 			data : {
        // 				userNumber : userNumber,
        // 				userPassword : pw			
// 			},
// 			success : function(result){
// 				$cuPwMsg.text(result);
// 			},
// 			error : function(a,b,c){
  // 				console.log(c);
  // }
  // });
}
});

//변경비밀번호를 입력하지 않으면 메세지
// 비밀번호 정규표현식 
const regex2 = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;
$sellerPwInput.on('blur', function(){
  if($(this).val()==''){
    $userPwMsg.text('비밀번호를 입력하세요');
    $userPwMsg.css("color","#c88e8e");
	}else if(regex2.test($(this).val())){
    $userPwMsg.text('사용가능한 비밀번호입니다.');
    $userPwMsg.css("color","#8eb4c8");
	}else{
    $userPwMsg.html('사용 불가능한 비밀번호입니다. <br>영어, 숫자, 특수문자를 포함하여 8글자 이상 작성하세요!');
    $userPwMsg.css("color","#c88e8e");
	}
	$chPwMsg.text('');
});

// 비밀번호 확인
// 변경 비밀번호를 입력하고 그 다음칸에 같은걸 입력했는지 확인
$checkPwInput.on('blur', function(){
	if($(this).val()==''){
		$chPwMsg.text('비밀번호를 입력하세요');
        $chPwMsg.css("color","#c88e8e");
	} else if($sellerPwInput.val()==$checkPwInput.val()){
		$chPwMsg.text("비밀번호가 일치합니다.");
        $chPwMsg.css("color", "#8eb4c8");
	}else{
		$chPwMsg.text("비밀번호가 일치하지 않습니다.");
		$chPwMsg.css("color","#c88e8e");
	}
});

// 전화번호 정규표현식?

// 이메일 정규표현식?

// 전체동의 체크박스 선택시 밑에 있는 동의체크도 모두 선택
let $agreeAll = $("#agreeAll");
console.log($agreeAll);

$agreeAll.on('click', function(){
    console.log($(".agree-check"));
    if($agreeAll.is(":checked")){
        $(".agree-check").prop("checked", true);
    }else{
        $(".agree-check").prop("checked", false);
    }
});

// 각 체크박스 선택하면 전체동의 풀리고 찍히게
$(".agree-check").on('click', function(){
    var total = $("input[name=chk]").length;
    var checked = $("input[name=chk]:checked").length;
    console.log(total);
    console.log(checked);
    if(total != checked){
        $agreeAll.prop("checked", false);
    }else{
        $agreeAll.prop("checked", true);
    }
});


// 취소버튼 클릭시 페이지 이동
$('.cancel-btn').on('click', function (){
    window.location.href = '/board/main';
});

