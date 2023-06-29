// 여기는 브랜드 모듈!!!!

// 브랜드 정보 조회 - 완료
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

// 브랜드 사진 파일 조회
export function findBrandFile(brandFileSize, callback){
    $.ajax({
        url : '/brands/findBrandFile',
        type : 'get',
        data : {brandFileSize : brandFileSize},
        dataType : 'json',
        success : function (result){
            // console.log(result);
            if(callback){
                callback(result);
            }
        },
        error : function (a,b,c){console.error(c)}
    });
}

// 브랜드정보 + 브랜드 대표 이미지 저장
export function saveBrandInfo(formData){
    $.ajax({
        url : '/brands/saveInfo',
        type : 'post',
        data : formData,
        processData : false,
        contentType : false,
        enctype : "multipart/form-data",
        success : function(){
            console.log('브랜드정보 수정완료');
        },
        error : function(a,b,c){console.error(c)}
    });
}

// 브랜드 정보 저장 - 완료
// export function saveBrandInfo(brandDto){
//     $.ajax({
//        url : '/brands/saveInfo',
//         type : 'post',
//         data : brandDto,
//         success : function(){
//            console.log('수정완료');
//         },
//         error : function(a,b,c,){console.error(c)}
//     });
// }


