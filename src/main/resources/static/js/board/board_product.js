$(document).ready(function () {
    let topButton = $(".allTop");

    $(window).scroll(function () {
        if ($(this).scrollTop() > 0) {
            topButton.fadeIn();
        } else {
            topButton.fadeOut();
        }
    });

    topButton.click(function () {
        $("html, body").animate({ scrollTop: 0 });
    });
});

// $(document).ready(function () {
//     $(".product-img").hover(
//         function () {
//             $(this).siblings(".product-modal").fadeIn();
//         },
//         function () {
//             $(this).siblings(".product-modal").fadeOut();
//         }
//     );
// });

// $(document).ready(function() {
//     // 반복할 요소의 배열
//     let products = /*[[${products}]]*/ [];
//
//     // 요소 추가 실행
//     addProducts(products);
// });
//
// function addProducts(products) {
//     let productRow = $('<div class="product-row"></div>');
//     let productCount = 0;
//
//     $.each(products, function (index, product) {
//         let productColumn = $('<div class="product-column"></div>');
//         let productContent = $('<div class="product-content"></div>');
//         let productImg = $('<div class="product-img"><img src="/img/boardImg/ho.jpg" alt="" /></div>');
//         let productInfo = $('<div class="product-info"></div>');
//         let brand = $('<div class="brand"><h4 th:text="' + product.brand + '"></h4></div>');
//         let productName = $('<div class="product-name"><p th:text="' + product.productName + '"></p></div>');
//         let price = $('<div class="product-price"><p th:text="' + product.price + '"></p></div>');
//
//         // 이미지 클릭 이벤트 처리
//         productImg.click(function() {
//             window.location.href = "/board/brandDetail";
//         });
//
//         productInfo.append(brand, productName);
//         productContent.append(productImg, productInfo, price);
//         productColumn.append(productContent);
//         productRow.append(productColumn);
//
//         productCount++;
//
//         if (productCount === 4) {
//             $(".product-list").append(productRow);
//             productRow = $('<div class="product-row"></div>');
//             productCount = 0;
//         }
//     });
//
//     // 마지막으로 남은 요소들을 추가
//     if (productCount > 0) {
//         $(".product-list").append(productRow);
//     }
//
//     // 화면에 추가된 요소들 확인
//     console.log($(".product-list").html());
// }

// $(document).ready(function () {
//     $(".product-img").hover(
//         function () {
//             $(this).siblings(".product-modal").fadeIn();
//         },
//         function () {
//             $(this).siblings(".product-modal").fadeOut();
//         }
//     );
// });

$(document).ready(function() {
    let products = /*[[${productSelect}]]*/ [];

    addProducts(products);
});

function addProducts(products) {
    let productRow = $('<div class="product-row"></div>');
    let productCount = 0;

    products.forEach(function(product) {
        let productColumn = $('<div class="product-column"></div>');
        let productContent = $('<div class="product-content"></div>');
        let productImg = $('<div class="product-img"></div>');
        let productInfo = $('<div class="product-info"></div>');
        let brand = $('<div class="brand"></div>');
        let productName = $('<div class="product-name"></div>');
        let productPrice = $('<div class="product-price"></div>');

        // 이미지 클릭 이벤트 처리
        productImg.click(function() {
            window.location.href = "/board/brandDetail";
        });

        brand.append('<h4>' + product.productName + '</h4>');
        productName.append('<p>' + product.productName + '</p>');
        productPrice.append('<p>' + product.productPrice + '</p>');

        productInfo.append(brand);
        productInfo.append(productName);
        productContent.append(productImg);
        productContent.append(productInfo);
        productContent.append(productPrice);
        productColumn.append(productContent);
        productRow.append(productColumn);

        productCount++;

        if (productCount === 4) {
            $(".product-list").append(productRow);
            productRow = $('<div class="product-row"></div>');
            productCount = 0;
        }
    });

    if (productCount > 0) {
        $(".product-list").append(productRow);
    }
}