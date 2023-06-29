//adminSearch.js는 manager_seller.js의 모듈을 만들어두는 파일
//이 모듈을 밖에서 사용할 수 있도록 내보내는 키워드가 export이다.

//판매자 검색 기능 모듈
export function getList(obj, callback,error){
    $.ajax({
        url : '/search/sellers',
        type : 'get',
        data : obj,
        dataType : 'json',
        success : function(map){
            if(callback){
        callback(map);
            }
        },
        error : error
    });
}
//판매자 검색후 상태변경 기능 모듈
export function sellerStatusAjax(statusObj,error) {
    $.ajax({
        url: `/search/${statusObj.sellerStatus}`,
        type: 'patch',
        data:  JSON.stringify(statusObj),
        contentType : 'application/json; charset=utf-8',
        success: function(){
            console.log('주문상태변경 ajax연결 성공');
        },
        error:error
    });
}
//상품검색페이지 검색 모듈
export function getProductList(pdl, callback,error){
    $.ajax({
        url : '/search/products',
        type : 'get',
        data :  pdl,
        dataType : 'json',
        // contentType : 'application/json; charset=utf-8',
        success : function(result){
            console.log('ㄹㄴㅇㄹㄴㄹㅇㄹㅇㄴㄹㅋㄹㅋㄴㅇㄹ');
            console.log(result);
            if(callback){
                callback(result);
            }
        },
        error : error
    });
}