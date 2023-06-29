import * as search2 from '../module/adminSearch.js';

function showPdl(map2){
    console.log(map2);
    let list = '';

    map2.forEach(i => {
        list += ` 
              <tr><!--상품관리 리스트 #1-->
              <td class="product-number">${i.productNumber}</td>
              <td>${i.productName}</td>
              <td>
                <select name="parcel-status" class="parcel-status">
                  <option value="1" ${1==i.productStatus ? `selected="selected"`:''}>판매 중</option>
                  <option value="0" ${0==i.productStatus ? `selected="selected"`:''}>판매 종료</option>
                </select>
              </td>
              <td>${i.brandName}</td>
              <td>${i.productRegisterDate}</td>
              <td>${i.sellerPhoneNumber}</td>
              <td>${i.sellerEmail}</td>
              <td>${i.sellerName}</td>
              <td><button type="button" class="save-btn">save</button></td>
          </tr>`;
    });
    $('.goods-list-body').html(list);

}

function showError(a, b, c) {
    console.error(c);
}

search2.getProductList({searchSelect : '', searchInput:''}, showPdl, showError);

//검색 조건에 따른 상품 조회
$('.search-btn').on('click', function (){
    let searchInput = $('.search-input').val();
    let searchSelect = $('.search-dropdown').val();
    console.log(searchInput);
    console.log(searchSelect);
    search2.getProductList({searchSelect : searchSelect, searchInput:searchInput}, showPdl, showError);
})

//상품 상태 변경
$('.goods-list-body').on('click','.save-btn',function (){
    let productStatus = $(this).closest('tr').find('.parcel-status').val();
    let productNumber = $(this).closest('tr').find('.product-number').text();
    let pstObj={
        productStatus:productStatus,
        productNumber:productNumber
    }
    console.log(pstObj);
    console.log("==========0000000000000000000000");
    search2.productStatusAjax(pstObj,showError);
});

//엔터처리==================================
$('.search-input').on('keydown', function (e){
    if(e.keyCode == 13){
        console.log('Enter');
        let searchInput = $('.search-input').val();
        let searchSelect = $('.search-dropdown').val();

        search2.getProductList({searchSelect : searchSelect, searchInput:searchInput}, showPdl, showError);

    }
});