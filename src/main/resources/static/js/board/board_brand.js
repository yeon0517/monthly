// 이건 top버튼
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





// 여긴 브랜드 반복 //ajax를 쓰면 될것같아여~
$(document).ready(function () {
    let brands = [[${brandSelect}]];

    addBrands(brands);
});

function addBrands(brands) {
    let columnRow = $('<div class="row"></div>');
    let columnCount = 0;

    $.each(brands, function (index, brand) {
        let column = $('<div class="column"></div>');
        let columnContent = $('<div class="column-content"></div>');
        let columnImg = $('<div class="column-img"><img src="' + brand.imgSrc + '" alt="" /></div>');
        let columnP = $('<div class="column-p"></div>');
        let title = $("<h4>" + brand.title + "</h4>");
        let description = $("<p>" + brand.description + "</p>");

        // 이미지 클릭 이벤트 처리
        columnImg.click(function () {
            window.location.href = "/board/brandDetail";
        });

        columnP.append(title, description);
        columnContent.append(columnImg, columnP);
        column.append(columnContent);
        columnRow.append(column);

        columnCount++;

        if (columnCount === 3) {
            $(".center").append(columnRow);
            columnRow = $('<div class="row"></div>');
            columnCount = 0;
        }
    });

    if (columnCount > 0) {
        $(".center").append(columnRow);
    }
}