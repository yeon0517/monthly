//adminSearch.js는 manager_seller.js의 모듈을 만들어두는 파일
//이 모듈을 밖에서 사용할 수 있도록 내보내는 키워드가 export이다.

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
