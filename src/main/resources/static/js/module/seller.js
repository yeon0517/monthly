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
export function checkCurrentPw(sellerPassword,callback){
    $.ajax({
			url : '/sellers/checkPw',
			type : 'get',
			data : {
				userNumber : sellerNumber,
				userPassword : sellerPassword
			},
			success : function(result){
				if(callback){
				    callback(result)
                };
			},
			error : function (a,b,c){console.error(c)}
});
}
