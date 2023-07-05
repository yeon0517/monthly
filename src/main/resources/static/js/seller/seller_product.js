import  * as product from '../module/product.js';

let page = 1;

product.getListPage({page : page}, showProduct, showError);

function showError(a,b,c){ console.error(c);}

function showProduct(map){
  let text = '';
  map.productList.forEach(product =>{
    text += `
    <tr>
      <form action="#">
          <td>${product.productNumber}</td>
          <td>${product.productRegisterDate}</td>
          <td>
            <select name="productStatus">
                ${product.productStatus == 0 ? '<option value="0" selected> 판매준비 </option>' : '<option value="0"> 판매준비 </option>'}
                ${product.productStatus == 1 ? '<option value="1" selected>판매중</option>' : '<option value="1">판매중</option>'}
                ${product.productStatus == 2 ? '<option value="2" selected>판매중지</option>' : '<option value="2">판매중지</option>' }
            </select>
          </td>
          <td>${product.productName}</td>
          <td>${product.productPrice}</td>
          <td>${product.productOption}</td>
          <td>${product.productAmount}</td>
          <td>
            <a href="/seller/modify?productNumber=${product.productNumber}" class="save-btn to-modify">
            상품 상세페이지로 이동</a>
          </td>
          <td>
    <button type="button" class="save-btn product-save">save</button>
  </td>
</form>
<tr>
`;
  });
    $('.product-list-body').html(text);
}

// <!--            @{/seller/modify(productNumber = ${product.productNumber})}-->
// <!--            <option value="2" th:selected="${product.productStatus}==2">판매중지</option> -->

function appendProduct(map){
    let text = '';

    map.productList.forEach(product =>{
        text += `
            <tr>
      <form action="#">
          <td>${product.productNumber}</td>
          <td>${product.productRegisterDate}</td>
          <td>
            <select name="productStatus">
                <option value="0"> 판매준비 </option>
                <option value="1">판매중</option>
                <option value="2">판매중지</option>
            </select>
          </td>
          <td>${product.productName}</td>
          <td>${product.productPrice}</td>
          <td>${product.productOption}</td>
          <td>${product.productAmount}</td>
          <td>
            <a href="#" class="save-btn to-modify">
            상품 상세페이지로 이동</a>
          </td>
          <td>
    <button type="button" class="save-btn product-save">save</button>
  </td>
</form>
<tr>
        `;
    });
        $('.product-list-body').append(text);
}


//무한스크롤페이징
$(window).on('scroll', function(){
    console.log($(window).scrollTop());
    console.log(`document :${$(document).height()}`);
    console.log(`window : ${$(window).height()}`);

    if(Math.round($(window).scrollTop())==$(document).height() - $(window).height()){
        console.log(++page);
        product.getListPage({page:page}, appendProduct, showError);
    }
});


//===================검색=================
let $search = $('.search-btn');
$search.on('click', function (){
    console.log('클릭할게요');
    let searchInput = $('.search-input').val();
    let searchSelect = $('.search-dropdown').val();
    let productStatus = $('input[name="product-status"]:checked').val();
    console.log(productStatus);
    let searchVo ={
        "page":page,
        "searchInput":searchInput,
        "searchSelect":searchSelect,
        "productStatus":productStatus
    }
    console.log(searchVo);

    product.searchProduct(searchVo,showProduct);
    $('.search-input').val('');
    $('input[name=product-status]').removeAttr('checked');
    $('input[name=product-status]').filter("[value=all]").prop("checked", true);

});

