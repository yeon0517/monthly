import  * as product from '../module/product.js';
import {modifyPStatus} from "../module/product.js";

let page = 1;
let searchInput = '';
let searchSelect = '';
let productStatus = '';

$(function (){
    // product.getListPage({page : page}, showProduct, showError);
    searchInput = $('.search-input').val();
    searchSelect = $('.search-dropdown').val();
    productStatus = $('input[name="product-status"]:checked').val();
    console.log(productStatus);
    let searchVo ={
        "page":page,
        "searchInput":searchInput,
        "searchSelect":searchSelect,
        "productStatus":productStatus
    }
    console.log(searchVo);

    product.searchProduct(searchVo,showProduct);
})




function showError(a,b,c){ console.error(c);}

//제품리스트 띄우기 + 페이징버튼 처리
function showProduct(map){
    if (map.productList.length == 0) {
        $('.empty').removeClass('none');
    } else {
        $('.empty').addClass('none');}
  let text = '';
  map.productList.forEach(product =>{
    text += `
    <tr class="list">
      <form action="#">
          <td class="product-number">${product.productNumber}</td>
          <td>${product.productRegisterDate}</td>
          <td>
            <select name="productStatus" class="product-status">
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
  //페이지버튼
  let pageBox ='';
  if(map.pageVo.prev==true){
      pageBox +=`
      <a>
          <li class="page-num prev" value="${map.pageVo.startPage -1}>&lt</li>
        </a>
      `;
  }
  for(let i=map.pageVo.startPage; i<=map.pageVo.endPage; i++){
      if(i==map.pageVo.criteria.page){
          pageBox +=`
          <a>
          <li class="page-num active">${i}</li>
          </a>
          `;
      }else{
          pageBox +=`
          <a><li class="page-num">${i}</li></a>
          `;
      }
  }
  if(map.pageVo.next==true){
      pageBox +=`
      <a><li class="page-num next" value="${map.pageVo.endPage +1}">&gt</li></a>
      `;
  }
    $('.product-list-body').html(text);
    $('.page-box').html(pageBox);

}

//페이지버튼을 눌렀을 때
$('.page-box').on('click','.page-num',function(){

   if($(this).hasClass('next')){
       return;
   }
   if($(this).hasClass('prev')){
       return;
   }
   let page = $(this).text();

    let searchVo ={
        "page":page,
        "searchInput":searchInput,
        "searchSelect":searchSelect,
        "productStatus":productStatus
    }
    product.searchProduct(searchVo,showProduct);

});
// 이전버튼 눌렀을 때
$('.page-box').on('click','.prev',function(){
   let page=$(this).val();
    let searchVo ={
        "page":page,
        "searchInput":searchInput,
        "searchSelect":searchSelect,
        "productStatus":productStatus
    }
    product.searchProduct(searchVo,showProduct);
});
//다음버튼 눌렀을 때
$('.page-box').on('click','.next',function(e){
    e.preventDefault();
    let page=$(this).val();
    let searchVo ={
        "page":page,
        "searchInput":searchInput,
        "searchSelect":searchSelect,
        "productStatus":productStatus
    }
    product.searchProduct(searchVo,showProduct);
});

// 제품상태를 변경하고 세이브 버튼을 누르기 전
$('.product-list-body').on('change', '.product-status', function(){
    $(this).parents('.list').find('.product-save').css("background-color","#c88e8e");
});
// 제품 상태 변경 저장버튼 눌렀을 떄
$(".product-list-body").on('click','.product-save',function(){
    // console.log(this);
    // console.log($(this).parents('.list'));
    let $list = $(this).parents('.list');
    // console.log($list.find('.product-status').val());
    // console.log($list.find('.product-number').text());
    let productDto = {
        "productNumber": $list.find('.product-number').text(),
        "productStatus": $list.find('.product-status').val()
    }
    console.log(productDto);
    product.modifyPStatus(productDto);
    $(this).css("background-color","#8eb4c8");
});

//===================검색=================
let $search = $('.search-btn');
$search.on('click', function (){
    console.log('클릭할게요');
    searchInput = $('.search-input').val();
    searchSelect = $('.search-dropdown').val();
    productStatus = $('input[name="product-status"]:checked').val();
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


// <!--            @{/seller/modify(productNumber = ${product.productNumber})}-->
// <!--            <option value="2" th:selected="${product.productStatus}==2">판매중지</option> -->

//무한스크롤페이징을 안할거라 어펜드는 필요없다.
/*function appendProduct(map){
    let text = '';

    map.productList.forEach(product =>{
        text += `
            <tr>
      <form action="#">
          <td>${product.productNumber}</td>
          <input type="hidden" value="${product.productRegisterDate}">
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
}*/

/*//무한스크롤페이징
$(window).on('scroll', function(){
    console.log($(window).scrollTop());
    console.log(`document :${$(document).height()}`);
    console.log(`window : ${$(window).height()}`);

    if(Math.round($(window).scrollTop())==$(document).height() - $(window).height()){
        console.log(++page);
        product.getListPage({page:page}, appendProduct, showError);
    }
});*/




