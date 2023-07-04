
let cnt = $('.subsCnt').val();

//console.log(cnt);


const subList = Array.from(Array(50), () => new Array(2));



let i = 0;

function calSubList(callback){

  $.ajax({

      url: '/calender/subsList',
      type:'post',
      dataType : 'json',
      async : false,
      success : function (result){
        console.log(result);

        result.forEach(sub => {

          subList[i].title = sub.productName +" "+ sub.productPrice +"원";
          subList[i].start = sub.subsStartDate;
          subList[i].extendedProps = {
            recurringMonthly: true, // 매달 반복
          };
          i++;
        });
        callback();
      },
  });
}





function calExSubList(callback){

  $.ajax({
    url: '/calender/exSubsList',
    type:'post',
    dataType : 'json',
    success : function (result){
      console.log(result);

      result.forEach(sub => {

        subList[i].title = sub.exSubsName +" "+ sub.exSubsPrice +"원";
        subList[i].start = sub.exSubsDate;
        subList[i].color = "#FF0000";
        subList[i].recurring = true; // 매달 반복
        i++;
      });
      callback();
    },

  });
}


function calenderStart(){
  document.addEventListener("DOMContentLoaded", function () {
    console.log("캘린더 시작하자 마자");
    console.log(subList);
    var calendarEl = document.getElementById("calendar");
    var calendar = new FullCalendar.Calendar(calendarEl, {
      timeZone: "UTC",
      initialView: "dayGridMonth", // 홈페이지에서 다른 형태의 view를 확인할  수 있다.
      events:
      //     [
      //   // 일정 데이터 추가 , DB의 event를 가져오려면 JSON 형식으로 변환해 events에 넣어주면된다.
      //   {
      //     title: "일정2" + "30000원",
      //     start: "2023-06-29 00:00:00",
      //     //end: "2023-06-30 00:00:00",
      //     // color 값을 추가해 색상도 변경 가능 자세한 내용은 하단의 사이트 참조
      //   },
      //   subList,
      // ],

      subList,

      headerToolbar: {
        center: "addEventButton", // headerToolbar에 버튼을 추가
      },
      customButtons: {
        addEventButton: {
          // 추가한 버튼 설정
          text: "일정 추가", // 버튼 내용
          click: function () {
            // 버튼 클릭 시 이벤트 추가
            $("#calendarModal").modal("show"); // modal 나타내기

            $("#addCalendar").on("click", function () {
              // modal의 추가 버튼 클릭 시
              var content = $("#calendar_content").val();
              var start_date = $("#calendar_start_date").val();
              // var end_date = $("#calendar_end_date").val();
              var price = $("#calendar_price").val();

              //내용 입력 여부 확인
              if (content == null || content == "") {
                alert("내용을 입력하세요.");
              } else if (start_date == "") {
                alert("날짜를 입력하세요.");
              } else if (price == "" || price == null) {
                alert("가격을 입력하세요");
              } else {
                // 정상적인 입력 시
                var obj = {
                  exSubsName: content,
                  exSubsDate: start_date,
                  // end: end_date,
                  exSubsPrice: price,
                }; //전송할 객체 생성

                console.log(obj); //서버로 해당 객체를 전달해서 DB 연동 가능
              }
              $.ajax({
                url: '/calender/exSubsReigster',
                type:'post',
                data : JSON.stringify(obj),
                contentType:'application/json; charset=utf-8',
                success : function (result){
                  $("#calendarModal").modal("hide");
                  location.reload();
                },
                errer : function (){
                  console.log("실패")
                }
              });

            });
          },
        },
      },

      eventClick: function (info){
        if(info.event._def.ui.backgroundColor == "#FF0000"){
          if(confirm("'"+ info.event.title +"'  외부구독을 삭제하시겠습니까 ?")){
            // 확인 클릭 시
            info.event.remove();

            console.log(info.event);
            var events = new Array(); // Json 데이터를 받기 위한 배열 선언
            var obj = new Object();
            let arr = info.event._def.title.split(" ");
            obj.exSubsName = arr[0];
            events.push(obj);

            console.log(events);
            $.ajax({
              url: '/calender/exSubsRemove',
              method: "DELETE",
              dataType: "json",
              data: JSON.stringify(obj),
              contentType: 'application/json; charset=utf-8',
              success : function (){
                console.log("삭제 성공");

              }
            });
            location.reload();
          }

        }else {
          if(confirm("'"+ info.event.title +"'  상품 구독을 삭제하시겠습니까 ?")){
            // 확인 클릭 시
            info.event.remove();

            console.log(info.event);// Json 데이터를 받기 위한 배열 선언
            var subs = new Object();
            let arr = info.event._def.title.split(" ");
            subs.productName = arr[0];
            //events.push(subs);

            console.log(subs);
            $.ajax({
              url: '/calender/subsRemove',
              method: "DELETE",
              dataType: "json",
              data: JSON.stringify(subs),
              contentType: 'application/json; charset=utf-8',
              success : function (){
                console.log("삭제 성공");

              }
            });
            location.reload();
          }

        }

      },
      editable: true, // false로 변경 시 draggable 작동 x
      displayEventTime: false, // 시간 표시 x
    });
    calendar.render();
  });
}


calSubList(function() {
  calExSubList(function() {
    calenderStart();
  });
});
