// $(document).ready(function() {
//     let brands = [[${brandSelect}]];
//     let products = [[${productSelect}]];
//
//     addBrands(brands, products);
// });
//
// function addBrands(brands, products) {
//     brands.forEach(function(brand) {
//         let wrap = $('<div class="wrap"></div>');
//         let whole = $('<div class="whole"></div>');
//         let wholeBox = $('<div class="whole-box"></div>');
//         let wrapDiv = $('<div class="wrap_div"></div>');
//         let brandImage = $('<a th:href="@{/board/brandDetail}"><img th:src="@{/img/boardImg/main.jpg}" alt="메인이미지" /></a>');
//
//         wrapDiv.append(brandImage);
//         wholeBox.append(wrapDiv);
//
//         let wrapList = $('<div class="wrap_list"></div>');
//         let wrapUl = $('<ul class="wrap_ul"></ul>');
//         let productCount = 0;
//
//         products.forEach(function(product) {
//             if (product.brandNumber === brand.brandNumber && productCount < 3) {
//                 let wrapIl = $('<li class="wrap_il"></li>');
//                 let box = $('<div class="box"></div>');
//                 let productImage = $('<a th:href="@{/board/productInfo}"><img th:src="@{/img/boardImg/ho.jpg}" alt="호" /></a>');
//                 let productName = $('<p class="box_name"><span th:text="${product.productName}"></span></p>');
//                 let productPrice = $('<p class="price" th:text="${product.productPrice}"></p>');
//
//                 box.append(productImage, productName, productPrice);
//                 wrapIl.append(box);
//                 wrapUl.append(wrapIl);
//
//                 productCount++;
//             }
//         });
//
//         wrapList.append(wrapUl);
//
//         wholeBox.append(wrapList);
//         whole.append(wholeBox);
//         wrap.append(whole);
//
//         $(".allContainer").append(wrap);
//     });
// }


document.addEventListener('DOMContentLoaded', function() {
    const wrapLists = document.querySelectorAll('.wrap_list');

    wrapLists.forEach(function(wrapList) {
        const divs = wrapList.querySelectorAll('.wrap_il');

        if (divs.length > 3) {
            for (let i = 3; i < divs.length; i++) {
                divs[i].style.display = 'none';
            }
        }
    });
});





