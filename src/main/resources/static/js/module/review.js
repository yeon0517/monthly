
//댓글 조회

export function getList(productNumber, callback,error){
    $.ajax({
       url: `/reviews/list/${productNumber}`,
       type:'get',
       dataType : 'json',
       success : function (result){
           if(callback){
               callback(result);
           }
       } ,
        error:error
    });
}


export function add(review,callback,error){
    $.ajax({
        url:'/reviews/review',
        type:'post',
        data : JSON.stringify(review),
        contentType:'application/json; charset=utf-8',
        success : function (){
            if(callback){
                callback();
            }
        },
        error:error
    });
}

export function getListPage(pageInfo, callback,error){
    console.log(pageInfo);
    $.ajax({
        url : `/reviews/list/${pageInfo.productNumber}/${pageInfo.page}`,
        type: 'get',
        dataType : 'json',
        success : function (result){
            if(callback){
                callback(result);
            }
        } ,
        error : error
    });
}

//시간 처리 메소드
export function timeForToday(value){
    // new Date() 현재 날짜와 시간
    const today = new Date();
    const timeValue = new Date(value);

    console.log(today);
    console.log(timeValue);

    // Math.floor()는 소수점을 내림 처리 해준다.
    // getTime()은 1970년 01/01 을 기준으로 지금까지 몇 ms가 지났는지 알려준다.
    const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);

    console.log(betweenTime);

    if(betweenTime < 1) { return "방금 전"; }
    if(betweenTime < 60) {
        return `${betweenTime}분 전`;
    }

    const betweenTimeHour = Math.floor(betweenTime / 60);
    if(betweenTimeHour < 24){
        return `${betweenTimeHour}시간 전`;
    }

    const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
    if(betweenTimeDay < 365){
        return `${betweenTimeDay}일 전`;
    }

    return `${Math.floor(betweenTimeDay / 365)}년 전`;
}

export function modify(review,callback,error){
    $.ajax({
        url: `/reviews/${review.reviewNumber}`,
        type : 'patch',
        data : JSON.stringify(review),
        contentType : 'application/json; charset=utf-8',
        success : function (){
            if(callback){
                callback();
            }
        },
        error : error

    });
}
export function remove(reviewNumber,callback,error){
    $.ajax({
        url : `/reviews/${reviewNumber}`,
        type : 'delete',
        success : function (){
            if(callback){
                callback();
            }
        },
        error : error

    });
}