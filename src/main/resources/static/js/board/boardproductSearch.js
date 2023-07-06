import * as boardSearch from '../module/boardSearch.js';

function show(map){
    let list = '';

    // <img th:src="'/product/upload/' + ${i.productFileUploadPath} + '/' + ${i.productFileUuid}+'_' + ${i.productFileName}" alt="" />
    map.forEach(i =>{
        list +=`
            <div class="product-column">
            <div class="product-content" >
              <div class="product-img">
                <a class="iii">

                </a>
              </div>
              <div class="product-info">
                <div class="brand">
                  <h4>'['+${i.brandName}+']'</h4>
                </div>
                <div class="product-name">
                  <p>${i.productName}</p>
                </div>
              </div>
              <div class="product-price">
                <p>${i.productPrice}+'원'</p>
              </div>
            </div>
          </div>
        `;
    });

    $('.product-row').html(list);
}

function showError(a, b, c) {
    console.error(c);
}


$('.imgBtn').on('click', function (){
    let searchInput = $('.keyword').val();
    /*                                                           pdl, callback,error 이렇게 ...          */
    boardSearch.submitSearchForm({searchInput : searchInput},show,showError);
});

