// const ctx = document.getElementById('myChart');
//
//   new Chart(ctx, {
//     type: 'bar',
//     data: {
//       labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
//       datasets: [{
//         label: '# of Votes',
//         data: [12, 19, 3, 5, 2, 3],
//         borderWidth: 1
//       }]
//     },
//     options: {
//       scales: {
//         y: {
//           beginAtZero: true
//         }
//       }
//     }
//   });


// let myChart = document.getElementById('myChart').getContext('2d');
//
// let mon = [];
// let data = [];
// charAjaxCategoty();
// function charAjaxCategoty() {
//     $.ajax({
//         url: `/adminChart/sellerChart`,
//         type: 'get',
//         dataType: 'json',
//         success: function (result) {
//             const serverData = result;
//             console.log(result);
//             getBarChart();
//             result
//                 .forEach(p =>{
//                 mon.push(p.sellerRegisterDate);
//                 data.push(p.registrationCount);
//                 })
//             console.log(mon,data);
//         },
//         error: function(xhr, status, error) {
//             console.log(error);
//         },
//     });
// }
//
//
// function getBarChart(){
//     let barChart = new Chart(myChart, {
//         type:'line',
//         data:{
//             labels : mon,
//             datasets:[{
//                 label :'협력 판매자 증가 추이',
//                 data : data,
//                 backgroundColor:[
//                     '#1E4A53'
//                 ]
//             }]
//         },
//         options: {
//             responsive: false,
//             scales: {
//                 y: {
//                     beginAtZero: true,
//                     suggestedMax: 30,
//                     max: 30
//                 },
//                 x: {
//                     display: true,
//                     title: {
//                         display: true,
//                         text: '월'
//                     }
//                 }
//             }
//         });
//
//
// }


let myChart = document.getElementById('myChart').getContext('2d');

let months = []; // 월 정보를 저장할 배열
let data = []; // 데이터를 저장할 배열
charAjaxCategory();

function charAjaxCategory() {
    $.ajax({
        url: `/adminChart/sellerChart`,
        type: 'get',
        dataType: 'json',
        success: function (result) {
            const serverData = result;
            console.log(result);
            prepareData(result);
            getBarChart();
        },
        error: function (xhr, status, error) {
            console.log(error);
        },
    });
}

function prepareData(result) {
    // 1월부터 12월까지의 월 정보를 배열에 추가
    for (let i = 1; i <= 12; i++) {
        months.push(i + '월');
    }

    // 데이터를 초기화하고 월별 데이터를 추가
    data = new Array(12).fill(0); // 0으로 초기화된 12개의 원소를 가진 배열
    result.forEach(p => {
        const month = parseInt(p.sellerRegisterDate.split('-')[1]);
        const count = p.registrationCount;
        data[month - 1] = count; // 해당 월의 인덱스에 데이터 추가
    });

    console.log(months, data);
}

function getBarChart() {
    let barChart = new Chart(myChart, {
        type: 'line',
        data: {
            labels: months,
            datasets: [{
                label: '협력 판매자 증가 추이',
                data: data,
                backgroundColor: '#1E4A53'
            }]
        },
        options: {
            responsive: false,
            scales: {
                y: {
                    beginAtZero: true,
                    suggestedMax: 30,
                    max: 30
                },
                x: {
                    display: true,
                    title: {
                        display: true,
                        text: '월별 현황'
                    }
                }
            }
        }
    });
}


//판매자 월간 매출액 시작해볼까~


// let myChartTwo = document.getElementById('myChartTwo').getContext('2d');
// let barChartTwo = new Chart(myChartTwo, {
//   type:'bar',
//   data:{
//       labels : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
//       datasets:[{
//           label : '판매자 월간 매출 액(만 단위)',
//           data : [
//             10,100,100,200,500,400,600,800,1000,850,900,1500
//           ],
//           backgroundColor:[
//             '#1E4A53'
//           ]
//       }]
//   }
//
// });

let myChartTwo = document.getElementById('myChartTwo').getContext('2d');
let labels = []; // 월 정보를 저장할 배열
let datas = [];

getChartTwoData();

function getChartTwoData() {
    $.ajax({
        url: "/adminChart/sellerChartTwo",
        type: "GET",
        dataType: "json",
        success: function(result) {
            console.log(result);
            prepareChartTwoData(result);
            console.log("=====================================")
            console.log(result)
            console.log("=====================================")
            drawChartTwo();
        },
        error: function(xhr, status, error) {
            console.log(error);
            // 오류 처리를 추가할 수 있습니다.
        }
    });
}

function prepareChartTwoData(result) {
    // 1월부터 12월까지의 월 정보를 배열에 추가
    for (let i = 1; i <= 12; i++) {
        labels.push(i + '월');
    }

    datas = new Array(12).fill(0);
    // 월별 데이터를 매칭하여 값 추가
    result.forEach(item => {
        const month = parseInt(item.paymentDate.split('-')[1]);
        const count = parseInt(item.paymentPriceCount);
        datas[month - 1] += count;
    });
}

function drawChartTwo() {
    let barChartTwo = new Chart(myChartTwo, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: '판매자 월간 매출 액',
                data: datas, // 수정된 부분
                backgroundColor: '#1E4A53'
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true,
                    suggestedMax: Math.max(...datas) + 100,
                }
            },
            plugins: {
                title: {
                    display: true,
                    text: '월별 판매자 매출 현황',
                    padding: {
                        bottom: 10
                    }
                }
            }
        }
    });
}
