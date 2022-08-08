

var xValues = ["Italy", "France", "Spain", "USA", "Argentina"];


var yValues = [55, 49, 44, 24, 15];


var chartDataStr2=decodeHtml(EmpData);
console.log(chartDataStr2)
var chartJsonArray2=JSON.parse(chartDataStr2);
console.log(chartJsonArray2)
var arrayLength2=chartJsonArray2.length;
var numericData2=[];
var labelData2=[];

for(let i=0;i<arrayLength2;i++){
    numericData2[i]=chartJsonArray2[i].projectCount;
    labelData2[i]=chartJsonArray2[i].firstName;
  }

new Chart(document.getElementById("myEmpChart"),{
    type:'bar',
    data:{
        labels: labelData2,
        datasets: [{
          label: 'Busiest Employees',
          backgroundColor: ["rgba(255, 99, 132)","rgba(255, 99, 132)","rgba(255, 99, 132)","green","green","green","green","green","green","green","green","green","green"],
          data: numericData2
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

function decodeHtml(html){
    var txt=document.createElement("textarea");
    txt.innerHTML=html;
    return txt.value;
  }