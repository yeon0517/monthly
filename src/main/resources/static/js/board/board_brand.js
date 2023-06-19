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
    let brands = [
        {
            imgSrc: "/img/boardImg/one.jpg",
            title: "모어포모레",
            description: "환경문제 해결을 적극적으로 기여하는 모레상점 기부 프로젝트",
        },
        {
            imgSrc: "/img/boardImg/two.jpg",
            title: "모어포모레",
            description: "환경문제 해결을 적극적으로 기여하는 모레상점 기부 프로젝트",
        },
        {
            imgSrc: "/img/boardImg/three.jpg",
            title: "모어포모레",
            description: "환경문제 해결을 적극적으로 기여하는 모레상점 기부 프로젝트",
        },
        {
            imgSrc: "/img/boardImg/two.jpg",
            title: "모어포모레",
            description: "환경문제 해결을 적극적으로 기여하는 모레상점 기부 프로젝트",
        },
        // 반복!!!!
    ];

    addBrands(brands);
});

function addBrands(brands) {
    let columnRow = $('<div class="row"></div>');
    let columnCount = 0;

    $.each(brands, function (index, brand) {
        let column = $('<div class="column"></div>');
        let columnContent = $('<div class="column-content"></div>');
        let columnImg = $(
            '<div class="column-img"><img src="' + brand.imgSrc + '" alt="" /></div>'
        );
        let columnP = $('<div class="column-p"></div>');
        let title = $("<h4>" + brand.title + "</h4>");
        let description = $("<p>" + brand.description + "</p>");

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
