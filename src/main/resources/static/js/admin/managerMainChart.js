// const ctx = document.getElementById('myChart');

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
let myChart = document.getElementById('myChart').getContext('2d');
let myChartTwo = document.getElementById('myChartTwo').getContext('2d');

let barChart = new Chart(myChart, {
  type:'line',
  data:{
      labels : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
      datasets:[{
          label :'협력 판매자 증가 추이',
          data : [
              5,10,18,25,50,80,130,200,250,350,500,700
          ],
          backgroundColor:[
            '#1E4A53'
          ]
      }]
  }
});


let barChartTwo = new Chart(myChartTwo, {
  type:'bar',
  data:{
      labels : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
      datasets:[{
          label : '월간 매출 액(만 단위)',
          data : [
            10,100,100,200,500,400,600,800,1000,850,900,1500
          ],
          backgroundColor:[
            '#1E4A53'
          ]
      }]
  }

});
