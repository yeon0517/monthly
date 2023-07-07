import * as search from '../module/adminSearch.js';

//모듈 경로는 일반적으로 상대경로로 접근한다.

function showList(map) {
    console.log(map);
    let list = '';

    map.forEach(u => {
        list += `
                <tr>
              <td>${u.userNumber}</td>
              <td>${u.userName}</td>
              <td>
                <select name="parcel-status" id="" class="parcel-status">
                  <option value="1">구독 중인 회원</option>
                  <option value="0">눈팅 회원</option>
                </select>
              </td>
              <td>${u.userId}</td>
              <td>${u.userPhoneNumber}</td>
              <td>${u.subsStartDate}</td>
              <td>${u.userBirthday}</td>
              <td>${u.userEmail}</td>
              <td>
               ${u.productName} </td>
              <td><button type="button" class="save-btn">save</button></td>
         
          </tr> 
        `;
    });
    $('.member-list-body').html(list);


}
search.getUserList({searchSelect : '', searchInput:''}, showList, showError);

//에러 코드
function showError(a, b, c) {
    console.error(c);
}


// 검색 조건에 따른 회원 조회
$('.search-btn').on('click', function (){
    let searchInput = $('.search-input').val();
    let searchSelect = $('.search-dropdown').val();
    search.getUserList({searchSelect : searchSelect, searchInput:searchInput}, showList, showError);
})


//엔터처리==================================
$('.search-input').on('keydown', function (e){
    if(e.keyCode == 13){
        console.log('Enter');
        let searchInput = $('.search-input').val();
        let searchSelect = $('.search-dropdown').val();
        search.getUserList({searchSelect : searchSelect, searchInput:searchInput}, showList, showError);

    }
});