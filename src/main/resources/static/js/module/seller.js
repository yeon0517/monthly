// 여기는 seller 모듈!!!


/**
 *
 * 아이디 중복 검사 모듈 <br>
 * 콜백함수의 매개변수로 0/1이 전달된다. <br>
 * 0 : 중복 없음 <br>
 * 1 : 중복 있음 <br>
 *
 * @param sellerId {String} 중복검사를 하려는 아이디
 * @param callback {function} 결과를 받아 실행시킬 콜백함수
 */
export function checkId(sellerId, callback){
    $.ajax({
        url : '/sellers/checkId',
        type : 'get',
        data : {sellerId: sellerId},
        success : function (result){
            if(callback){
                callback(result);
            }
        },
        error : function (a,b,c){console.error(c)}
    });
}

// 현재 비밀번호 맡는지 체크
export function checkCurrentPw(sellerPassword,callback){
    $.ajax({
			url : '/sellers/checkPw',
			type : 'get',
			data : {sellerPassword : sellerPassword},
			success : function(result){
			    console.log('조회완료');
				if(callback){
				    callback(result)
                };
			},
			error : function (a,b,c){console.error(c)}
});
}

// 판매자 정보 수정
export function modifySellerInfo(sellerDto,){
    $.ajax({
        url : '/sellers/modifyInfo',
        type : 'patch',
        data :sellerDto,
        contentType : 'application/json;charset=utf-8',
        success : function(){
            console.log("수정완료")
        },
        error : function(a,b,c,){console.error(c)}
    });
}

// 판매자 정보 조회
export function findSellerInfo(callback){
    console.log('ajax')
    $.ajax({
       url : '/sellers/findInfo',
       type : 'get',
       dataType : 'json',
       success : function(result){
           if(callback){
               callback(result);
           }
           console.log('조회완료')
        },
       erroe : function(a,b,c){console.error(c)}
    });
}


