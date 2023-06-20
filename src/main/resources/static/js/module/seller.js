// 여기는 seller 모듈!!!


/**
 *
 * @param String sellerId
 * @param callback
 * @param error
 */
export function checkId(sellerId, callback, error){
    $.ajax({
        url : '/sellers/checkId',
        type : 'get',
        data : {sellerId: id},
        success : function (result){
            if(callback){
                callback();
            }
        },
        error : error
    });
}
