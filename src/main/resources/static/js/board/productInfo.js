$(document).ready(function () {
  calendarInit();
});
/*
    달력 렌더링 할 때 필요한 정보 목록 

    현재 월(초기값 : 현재 시간)
    금월 마지막일 날짜와 요일
    전월 마지막일 날짜와 요일
*/

function calendarInit() {
  // 날짜 정보 가져오기
  var date = new Date(); // 현재 날짜(로컬 기준) 가져오기
  var utc = date.getTime() + date.getTimezoneOffset() * 60 * 1000; // uct 표준시 도출
  var kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
  var today = new Date(utc + kstGap); // 한국 시간으로 date 객체 만들기(오늘)

  var thisMonth = new Date(
    today.getFullYear(),
    today.getMonth(),
    today.getDate()
  );
  // 달력에서 표기하는 날짜 객체

  var currentYear = thisMonth.getFullYear(); // 달력에서 표기하는 연
  var currentMonth = thisMonth.getMonth(); // 달력에서 표기하는 월
  var currentDate = thisMonth.getDate(); // 달력에서 표기하는 일

  // kst 기준 현재시간
  // console.log(thisMonth);

  // 캘린더 렌더링
  renderCalender(thisMonth);

  function renderCalender(thisMonth) {
    // 렌더링을 위한 데이터 정리
    currentYear = thisMonth.getFullYear();
    currentMonth = thisMonth.getMonth();
    currentDate = thisMonth.getDate();

    // 이전 달의 마지막 날 날짜와 요일 구하기
    var startDay = new Date(currentYear, currentMonth, 0);
    var prevDate = startDay.getDate();
    var prevDay = startDay.getDay();

    // 이번 달의 마지막날 날짜와 요일 구하기
    var endDay = new Date(currentYear, currentMonth + 1, 0);
    var nextDate = endDay.getDate();
    var nextDay = endDay.getDay();

    // console.log(prevDate, prevDay, nextDate, nextDay);

    // 현재 월 표기
    $(".year-month").text(currentYear + "-" + (currentMonth + 1));

    // 렌더링 html 요소 생성
    calendar = document.querySelector(".dates");
    calendar.innerHTML = "";

    // 지난달
    for (var i = prevDate - prevDay + 1; i <= prevDate; i++) {
      calendar.innerHTML =
        calendar.innerHTML + '<div class="day prev disable">' + i + "</div>";
    }
    // 이번달
    for (var i = 1; i <= nextDate; i++) {
      calendar.innerHTML =
        calendar.innerHTML + '<div class="day current">' + i + "</div>";
    }
    // 다음달
    for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
      calendar.innerHTML =
        calendar.innerHTML + '<div class="day next disable">' + i + "</div>";
    }

    // 오늘 날짜 표기
    if (today.getMonth() == currentMonth) {
      todayDate = today.getDate();
      var currentMonthDate = document.querySelectorAll(".dates .current");
      currentMonthDate[todayDate - 1].classList.add("today");
    }
  }

  // 이전달로 이동
  $(".go-prev").on("click", function () {
    thisMonth = new Date(currentYear, currentMonth - 1, 1);
    renderCalender(thisMonth);
  });

  // 다음달로 이동
  $(".go-next").on("click", function () {
    thisMonth = new Date(currentYear, currentMonth + 1, 1);
    renderCalender(thisMonth);
  });
}

//날짜 넣기
$(".dates").on("click", ".current", function (event) {
  event.preventDefault();
  let year = $(".year-month").text();
  let day = $(this).text();
  // $(".result").text(year + "-" + day);
  $(".result").text(year + "-" + day);
});

//가격 넣기
let count = 1;

$("#cnt").val(count);
$(".countResult").text("(" + count + "개)");

$(".up").on("click", function () {
  let price = $(".price").data("price");
  count++;
  $(".price").text(Math.round(price) * count + "원");
  $(".pay").text(Math.round(price) * count + "원");
  console.log(count);
  $("#cnt").val(count);
  $(".countResult").text("(" + count + "개)");
});

$(".down").on("click", function () {
  let price = $(".price").data("price");
  if (count > 1) {
    count--;
  }
  $(".price").text(Math.round(price) * count + "원");
  $(".pay").text(Math.round(price) * count + "원");
  console.log(count);
  $("#cnt").val(count);
  $(".countResult").text("(" + count + "개)");
});

const nonClick = document.querySelectorAll(".TabPanelList > li");

function PanelClick(event) {
  // div에서 모든 "click" 클래스 제거
  nonClick.forEach((e) => {
    e.classList.remove("changeColor");
  });
  // 클릭한 div만 "click"클래스 추가
  event.target.classList.add("changeColor");
}

nonClick.forEach((e) => {
  e.addEventListener("click", PanelClick);
});

$(document).ready(function () {
  $(".proInfo").click(function () {
    let offset = $(".cont").offset(); //선택한 태그의 위치를 반환

    //animate()메서드를 이용해서 선택한 태그의 스크롤 위치를 지정해서 0.4초 동안 부드럽게 해당 위치로 이동함

    $("html").animate({ scrollTop: offset.top }, 400);
  });
});

$(document).ready(function () {
  $(".review").click(function () {
    let offset = $(".cont_all").offset(); //선택한 태그의 위치를 반환

    //animate()메서드를 이용해서 선택한 태그의 스크롤 위치를 지정해서 0.4초 동안 부드럽게 해당 위치로 이동함

    $("html").animate({ scrollTop: offset.top }, 400);
  });
});

$(document).ready(function () {
  $(".caution").click(function () {
    let offset = $(".proReview").offset(); //선택한 태그의 위치를 반환

    //animate()메서드를 이용해서 선택한 태그의 스크롤 위치를 지정해서 0.4초 동안 부드럽게 해당 위치로 이동함

    $("html").animate({ scrollTop: offset.top }, 400);
  });
});


window.addEventListener("load", function () {
  let contentHeight = document.querySelector(
      ".detailinfo > .content"
  ).offsetHeight; //컨텐츠 높이 얻기
  if (contentHeight <= 300) {
    document.querySelector(".detailinfo").classList.remove("showstep1"); // 초기값보다 작으면 전체 컨텐츠 표시
    document.querySelector(".btn_open").classList.add("hide"); // 버튼 감춤
  }
});

document.addEventListener("DOMContentLoaded", function () {
  //DOM 생성 후 이벤트 리스너 등록
  //더보기 버튼 이벤트 리스너
  document.querySelector(".btn_open").addEventListener("click", function (e) {
    let classList = document.querySelector(".detailinfo").classList; // 더보기 프레임의 클래스 정보 얻기
    let contentHeight = document.querySelector(
        ".detailinfo > .content"
    ).offsetHeight; //컨텐츠 높이 얻기

    // 2단계이면 전체보기로
    if (classList.contains("showstep2")) {
      classList.remove("showstep2");
    }
    // 1단계이면 2단계로
    if (classList.contains("showstep1")) {
      classList.remove("showstep1");
      if (contentHeight > 600) {
        classList.add("showstep2");
      } else {
        document.querySelector(".btn_open").classList.add("hide");
      }
    }
    //전체보기시 더보기 버튼 감추기 & 감추기 버튼 표시
    if (!classList.contains("showstep1") && !classList.contains("showstep2")) {
      e.target.classList.add("hide");
      document.querySelector(".btn_close").classList.remove("hide");
    }
  });
});

document.querySelector(".btn_close").addEventListener("click", function (e) {
  e.target.classList.add("hide");
  document.querySelector(".btn_open").classList.remove("hide"); // 더보기 버튼 감춤
  document.querySelector(".detailinfo").classList.add("showstep1"); // 초기 감춤 상태로 복귀
});
