
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
// function submitSearchForm() {
//     // 검색어 입력값 가져오기
//     let keyword = document.getElementById("keyword").value;
//
//     // 검색 조건 선택값 가져오기
//     let searchSelect = document.getElementById("search").value;
//
//     // Ajax 요청 보내기
//     $.ajax({
//         type: "GET",
//         url: "/boards/search",
//         data: {
//             searchSelect: searchSelect,
//             searchInput: keyword
//         },
//         success: function(response) {
//             // 검색 결과를 받은 후의 처리
//             displaySearchResults(response);
//         },
//         error: function(error) {
//             console.log(error);
//         }
//     });
// }
//
// function displaySearchResults(results) {
//     let searchResultsContainer = document.getElementById("searchResults");
//
//     // 이전에 표시된 결과 초기화
//     searchResultsContainer.innerHTML = "";
//
//     // 결과를 순회하며 요소 추가
//     results.forEach(function(result) {
//         let resultItem = document.createElement("div");
//         resultItem.className = "searchResultItem";
//
//         // 결과 정보 표시
//         let productName = document.createElement("p");
//         productName.textContent = "Product Name: " + result.productName;
//         resultItem.appendChild(productName);
//
//         let brandName = document.createElement("p");
//         brandName.textContent = "Brand Name: " + result.brandName;
//         resultItem.appendChild(brandName);
//
//         // 결과 요소를 컨테이너에 추가
//         searchResultsContainer.appendChild(resultItem);
//     });
// }










