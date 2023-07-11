// 여기는 주문 모듈!

// 주문 띄우기 위해 리스트 가져오기

export function findParcelList(searchVo,callback){
    $.ajax({
        url : `/sellers/main/${searchVo.page}`,
        type : 'get',
        data : searchVo,
        dataType : 'json',
        success : function(result){
            if(callback){
                console.log(result);
                callback(result)
            }
        },
        error : function(a,b,c,){console.error(c)}
    });
}

export function modifyParcel(parcelVo){
    $.ajax({
        url : `/sellers/mParcel`,
        type : 'patch',
        data : JSON.stringify(parcelVo),
        contentType : 'application/json;charset=utf-8',
        success : function(){
            console.log('주문상태 변경완료')
        },
        error : function (a,b,c){console.error(c)}
    });
}