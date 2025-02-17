import * as search from '../module/adminSearch.js';

//모듈 경로는 일반적으로 상대경로로 접근한다.

function showList(map) {
    console.log(map);
    let list = '';

    map.forEach(u => {
        list += `
        <tr> <!--판매자 리스트 띄움 ajax처리 #1-->
            <td class="seller--number">${u.sellerNumber}</td>
            <td>${u.sellerName}</td>
            <td>
                <select name="parcel-status"  class="parcel-status">
                    <option value="1" ${1==u.sellerStatus ? `selected="selected"`:''}  >영업신청</option>
                    <option value="2" ${2==u.sellerStatus ? `selected="selected"`:''}>영업허가</option>
                    <option value="0" ${0==u.sellerStatus ? `selected="selected"`:''}>폐업</option>
                </select>
            </td>
            <td>${u.sellerId}</td>
            <td>${u.sellerPhoneNumber}</td>
            <td>${u.sellerRegisterDate}</td>
            <td>${u.sellerCompanyRegisterNumber}</td>
            <td>${u.sellerEmail}</td>
            <td>${u.sellerAddress1}</td>
            <td>

                <button type="button" class="brand-link" data-seller-number="${u.sellerNumber}"> 브랜드 이동</button>   
            </td>
            <td><button type="button" class="save-btn">save</button></td>
        </tr>`;
    });
    $('.seller-list-body').html(list);


}
search.getList({period : '', searchSelect : '', searchInput:''}, showList, showError);

//구독자 페이지로 버튼 누르면 이동
$('.seller-list-body').on('click','.brand-link',function (){
    let sellerNumber = $(this).data('seller-number');
// Perform the page redirect based on sellerNumber
    window.location.href = `/admin/subMember?sellerNumber=${sellerNumber}`;
});

//에러 코드
function showError(a, b, c) {
    console.error(c);
}


// 검색 조건에 따른 회원 조회
$('.search-btn').on('click', function (){
    let searchInput = $('.search-input').val();
    let searchSelect = $('.search-dropdown').val();
    let searchPeriod = $('input[name=period]:checked').val();
    search.getList({period : searchPeriod, searchSelect : searchSelect, searchInput:searchInput}, showList, showError);
    if(searchInput==null){
        $('input[name=period]:checked').val('');
    }else{
        $('.search-input').val('');
    }
})

//판매자 상태 변경
$('.seller-list-body').on('click', '.save-btn', function() {
    // 해당 회원번호, 바꿔야 하는 상태
    let sellerStatus = $(this).closest('tr').find('.parcel-status').val();
    let sellerNumber = $(this).closest('tr').find('.seller--number').text();
    let statusObj={
        sellerStatus : sellerStatus,
        sellerNumber : sellerNumber
    }
    console.log(statusObj);
    search.sellerStatusAjax(statusObj,showError);
});





//엔터처리==================================
$('.search-input').on('keydown', function (e){
    if(e.keyCode == 13){
        console.log('Enter');
        let searchInput = $('.search-input').val();
        let searchSelect = $('.search-dropdown').val();
        let searchPeriod = $('input[name=period]:checked').val();
        search.getList({period : searchPeriod, searchSelect : searchSelect, searchInput:searchInput}, showList, showError);

    }
});