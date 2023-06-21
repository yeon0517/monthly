// $(document).ready(function () {
//     let brands = [
//         {
//             imgSrc: "/img/boardImg/one.jpg",
//             title: "[브랜드이름넣어]",
//             description: "고체바 & 숲 키링 세트",
//             price: "18,000원",
//         },
//         {
//             imgSrc: "/img/boardImg/one.jpg",
//             title: "[브랜드이름넣어]",
//             description: "고체바 & 숲 키링 세트",
//             price: "18,000원",
//         },
//         {
//             imgSrc: "/img/boardImg/one.jpg",
//             title: "[브랜드이름넣어]",
//             description: "고체바 & 숲 키링 세트",
//             price: "18,000원",
//         },
//         {
//             imgSrc: "/img/boardImg/one.jpg",
//             title: "[브랜드이름넣어]",
//             description: "고체바 & 숲 키링 세트",
//             price: "18,000원",
//         },
//         {
//             imgSrc: "/img/boardImg/one.jpg",
//             title: "[브랜드이름넣어]",
//             description: "고체바 & 숲 키링 세트",
//             price: "18,000원",
//         },
//         // 반복!!!!
//     ];
//
//     addBrands(brands);
// });
//
// function addBrands(brands) {
//     let brandWrap = $('<div class="brand-wrap"></div>');
//     let brandCount = 0;
//
//     $.each(brands, function (index, brand) {
//         let brandList = $('<div class="brand-list"></div>');
//         let listImg = $(
//             '<div class="list-img"><img src="' + brand.imgSrc + '" alt="" /></div>'
//         );
//         let listP = $('<div class="list-p"></div>');
//         let title = $("<h4>" + brand.title + "</h4>");
//         let description = $("<p>" + brand.description + "</p>");
//         let listPrice = $(
//             '<div class="list-price"><p>' + brand.price + "</p></div>"
//         );
//
//         listP.append(title, description);
//         brandList.append(listImg, listP, listPrice);
//         brandWrap.append(brandList);
//
//         brandCount++;
//
//         if (brandCount === 4) {
//             $(".center").append(brandWrap);
//             brandWrap = $('<div class="brand-wrap"></div>');
//             brandCount = 0;
//         }
//     });
//
//     if (brandCount > 0) {
//         $(".center").append(brandWrap);
//     }
// }


$(document).ready(function () {
    let brands = /*[[${brands}]]*/ [];  // 브랜드 데이터를 타임리프에서 전달 받습니다.
    addBrands(brands);
});

function addBrands(brands) {
    let brandWrap = $('<div class="brand-wrap"></div>');
    let brandCount = 0;

    $.each(brands, function (index, brand) {
        let brandList = $('<div class="brand-list"></div>');
        let listImg = $('<div class="list-img"><img src="' + brand.imgSrc + '" alt="" /></div>');
        let listP = $('<div class="list-p"></div>');
        let title = $('<h4>' + brand.brandName + '</h4>');
        let description = $('<p>' + brand.brandContents + '</p>');
        let listPrice = $('<div class="list-price"><p>' + brand.brandName + '</p></div>');

        listP.append(title, description);
        brandList.append(listImg, listP, listPrice);
        brandWrap.append(brandList);

        brandCount++;

        if (brandCount === 4) {
            $(".center").append(brandWrap);
            brandWrap = $('<div class="brand-wrap"></div>');
            brandCount = 0;
        }
    });

    if (brandCount > 0) {
        $(".center").append(brandWrap);
    }
}