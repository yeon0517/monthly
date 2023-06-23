
//검색 누르면 나오는거
$(document).ready(function () {
    $(".search_icon").click(function () {
        event.preventDefault(); //스크롤 막는거
        if ($(".search_btn").css("display") == "block") {
            $(".search_btn").css("display", "none");
        } else {
            $(".search_btn").css("display", "block");
        }
    });
});

// 더보기 누르면 나오는거
$(document).ready(function () {
    $(".allother").click(function () {
        event.preventDefault();
        if ($(".sidenav").css("display") == "block") {
            $(".sidenav").css("display", "none");
        } else {
            $(".sidenav").css("display", "block");
        }
    });
});

//더보기 엑스 버튼 누르면 없애기

$(document).ready(function () {
    $("#cancelimg").click(function () {
        if ($(".sidenav").css("display") == "block") {
            $(".sidenav").css("display", "none");
        } else {
            $(".sidenav").css("display", "block");
        }
    });
});

// top버튼 누르면 맨 위로 올라오는 기능
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

