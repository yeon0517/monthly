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

$(document).ready(function () {
    $(".product-img").hover(
        function () {
            $(this).siblings(".product-modal").fadeIn();
        },
        function () {
            $(this).siblings(".product-modal").fadeOut();
        }
    );
});

$(document).ready(function () {
    // 반복할 요소의 배열
    let products = [
        {
            imgSrc: "/img/product (3).jpg",
            brand: "[브랜드이름]",
            productName: "Y2K 호보백",
            price: "39,000원",
        },
        {
            imgSrc: "/img/product (2).jpg",
            brand: "[브랜드이름]",
            productName: "Y2K 호보백",
            price: "39,000원",
        },
        {
            imgSrc: "/img/product (3).jpg",
            brand: "[브랜드이름]",
            productName: "Y2K 호보백",
            price: "39,000원",
        },
        {
            imgSrc: "/img/product (4).jpg",
            brand: "[브랜드이름]",
            productName: "Y2K 호보백",
            price: "39,000원",
        },
        {
            imgSrc: "/img/product (4).jpg",
            brand: "[브랜드이름]",
            productName: "Y2K 호보백",
            price: "39,000원",
        },
        // 반복되는 것들
    ];

    // 요소 반복 및 추가 함수

    // 요소 추가 실행
    addProducts(products);
});

function addProducts(products) {
    let productRow = $('<div class="product-row"></div>');
    let productCount = 0;

    $.each(products, function (index, product) {
        let productColumn = $('<div class="product-column"></div>');
        let productContent = $('<div class="product-content"></div>');
        let productImg = $(
            '<div class="product-img"><img src="' +
            product.imgSrc +
            '" alt="" /></div>'
        );
        let productInfo = $('<div class="product-info"></div>');
        let brand = $('<div class="brand"><h4>' + product.brand + "</h4></div>");
        let productName = $(
            '<div class="product-name"><p>' + product.productName + "</p></div>"
        );
        let price = $(
            '<div class="product-price"><p>' + product.price + "</p></div>"
        );

        productInfo.append(brand, productName);
        productContent.append(productImg, productInfo, price);
        productColumn.append(productContent);
        productRow.append(productColumn);

        productCount++;

        if (productCount === 4) {
            $(".product-list").append(productRow);
            productRow = $('<div class="product-row"></div>');
            productCount = 0;
        }
    });

    // 마지막으로 남은 요소들을 추가
    if (productCount > 0) {
        $(".product-list").append(productRow);
    }
}
