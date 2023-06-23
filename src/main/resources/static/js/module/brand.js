// 여기는 브랜드 모듈!!!!

// 브랜드 정보 조회
export function findBrandInfo(callback){
    console.log('ajax')
    $.ajax({
        url : '/brands/findInfo',
        type : 'get',
        dataType : 'json',
        success : function(result){
            if(callback){
                callback(result);
            }
            // console.log('조회완료')
            console.log(result);
        },
        error : function(a,b,c){console.error(c)}
    });
}
// 브랜드 사진 조회

// 브랜드 정보 저장
export function saveBrandInfo(brandDto){
    $.ajax({
       url : '/brands/saveInfo',
        type : 'post',
        data : brandDto,
        success : function(){
           console.log('수정완료');
        },
        error : function(a,b,c,){console.error(c)}
    });
}

// 브랜드 사진 저장
//