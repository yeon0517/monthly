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

