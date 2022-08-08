

var xValues = ["Italy", "France", "Spain", "USA", "Argentina"];


var yValues = [55, 49, 44, 24, 15];


new Chart(document.getElementById("myEmpChart"),{
    type:'bar',
    data:{
        labels: xValues,
        datasets: [{
          label: 'Busiest Employees',
          backgroundColor: ["rgba(255, 99, 132)","rgba(255, 99, 132)","rgba(255, 99, 132)","green","green","green","green","green","green","green","green","green","green"],
          data: yValues
        }]
      },
    options:{
        scales: {
            y: {
              beginAtZero: true
            }
          }
        }
})