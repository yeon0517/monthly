// 여기는 제품 모듈!

// 제품 띄우기 위해 리스트 가져오기
export function getList(callback, error){
    $.ajax({
        url : `/sellers/list/`,
        type : 'get',
        success : function(result){
            if(callback){
                callback(result);
            }
        },
        error : error
    });
}

export function getListPage(pageInfo, callback, error){
    $.ajax({
       url : `/sellers/list/${pageInfo.page}`,
       type : 'get',
       dataType : 'json',
       success : function (result){
           if(callback){
               console.log(result);
               callback(result)
           }
       },
        error : error
    });
}