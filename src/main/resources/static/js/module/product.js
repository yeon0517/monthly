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

export function searchProduct(searchVo,callback){
    $.ajax({
        url : `/sellers/searchP/${searchVo.page}`,
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

export function modifyPStatus(productDto){
    $.ajax({
        url : `/sellers/pStatus`,
        type : 'patch',
        data : JSON.stringify(productDto),
        contentType : 'application/json;charset=utf-8',
        success : function(){
            console.log('상품판매상태 변경완료')
            alert("수정되었습니다.")
        },
        error : function (a,b,c){console.error(c)}
    });
}