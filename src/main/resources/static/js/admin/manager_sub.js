import * as sub from '../module/adminSearch.js';

function showList(map){
    console.log(map);
    let list = '';

    map.forEach(i =>{
        list +=`
          <tr> 
          <input type="hidden" value="${i.productNumber}">
                <td>${i.userNumber}</td>
                <td>${i.subsNumber}</td>
                <td>${i.productName}</td>
                <td>${i.userName}</td>
                <td>${i.userId}</td>
                <td>${i.subsStartDate}</td>
                <td>20일</td>
                <td>
                  <button type="button" class="message-submit-btn"> 전송 </button>   
                </td>
                <td><button type="button" class="out-btn"> 구독 취소 </button></td>
             </tr>
        `
    });
    $('.sub-list-body').html(list);
}

//에러 코드
function showError(a, b, c) {
    console.error(c);
}

sub.productSubsUserList({subscriberInput:'',productNumber:''},showList,showError);


// 검색 조건에 따른 구독자 조회
$('.search-btn').on('click', function (){
    let searchInput = $('.subscriber-input').val();
    // let productNumber = $('.subscriber-input').val();
    console.log(searchInput);
    console.log(productNumber);

    sub.productSubsUserList({subscriberInput : searchInput, productNumber : productNumber}, showList, showError);

})