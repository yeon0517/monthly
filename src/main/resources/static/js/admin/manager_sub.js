import * as sub from '../module/adminSearch.js';

function showList(map){
    console.log(map);
    let list = '';

    map.forEach(i =>{
        list +=`
          <tr class="subsNumber" data-num="${i.subsNumber}"> 
                <td>${i.userNumber}</td>
                <td >${i.subsNumber}</td>
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
        `;
    });
    $('.sub-list-body').html(list);
}

//에러 코드
function showError(a, b, c) {
    console.error(c);
}

let globalProductNumber = 0;
let globalSearchInput = '';

// 검색 조건에 따른 구독자 조회
$('.search-btn-ct').on('click', '.search-btn',function (e){
    let productNumber = $(e.target).closest('tr').find('.product-number').text();
    let searchInput = $(e.target).closest('tr').find('.subscriber-input').text();


    globalProductNumber = productNumber;
    globalSearchInput = searchInput;

    sub.productSubsUserList({subscriberInput : searchInput, productNumber : productNumber}, showList, showError);

})
//기간 조건 클릭
$('.period-input').on('click','.period', function (){
    let searchPeriod = $('input[name=period]:checked').val();
    sub.productSubsUserList({subscriberInput : globalSearchInput, productNumber : globalProductNumber, period : searchPeriod}, showList, showError);

})


//강제 구독 취소
$('.sub-list-body').on('click','.out-btn',function (){
   let subsNumber = $(this).closest('.subsNumber').data('num');
    let searchPeriod = $('input[name=period]:checked').val();
    console.log(subsNumber);
    console.log(subsNumber+"번 구독자 삭제 완료====================");
    sub.removeSubs(subsNumber, function (){
        sub.productSubsUserList({subscriberInput : globalSearchInput, productNumber : globalProductNumber, period : searchPeriod}, showList, showError);
    },showError);

});
