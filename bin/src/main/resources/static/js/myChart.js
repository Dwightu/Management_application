// For a pie chart

var chartDataStr=decodeHtml(chartData);
var chartJsonArray=JSON.parse(chartDataStr);

var arrayLength=chartJsonArray.length;
var numericData=[];
var labelData=[];

for(let i=0;i<arrayLength;i++){
  numericData[i]=chartJsonArray[i].count;
  labelData[i]=chartJsonArray[i].label;
}

const labels = [
    'January',
    'February',
    'March',
  ];

new Chart(document.getElementById("myPieChart"),{
    type:'pie',
    data:{
        labels: labelData,
        datasets: [{
          label: 'My First dataset',
          backgroundColor: ["#3e95cs","#8e5ea2","#3cba9f"],
          data: numericData
        }]
      },
    options:{
      title:{
        display:true,
        text:'Project Statuses'
      }
    }
})

function decodeHtml(html){
  var txt=document.createElement("textarea");
  txt.innerHTML=html;
  return txt.value;
}