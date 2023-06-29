
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



//검색하면 결과 나오는 ajax
function getSearchList() {
    $.ajax({
        type: 'GET',
        url: "/board/product",
        data: $("form[name=searchForm]").serialize(),
        success: function(result) {
            if (result.length >= 1) {
                result.forEach(function(item) {
                    var str = ""; // str 변수 초기화
                    // str 변수에 결과를 추가하는 로직 작성
                    // 예를 들어, 결과를 어떤 요소에 출력하려면 다음과 같이 작성할 수 있습니다.
                    str += "<p>" + item.title + "</p>";
                    str += "<p>" + item.description + "</p>";
                    $("#searchResults").append(str); // 결과를 출력할 요소의 ID에 맞게 수정
                });
            }
        },
        error: function(error) {
            console.log(error); // 에러 처리 로직 추가
        }
    });
}

























