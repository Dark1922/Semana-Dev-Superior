import Chart from 'react-apexcharts';
import axios from 'axios';
import { BASE_URL } from 'utils/requests';
import { SaleSum } from 'types/sale';

type ChartData = { //vamos criar um tipo parecido com interface
  labels: string[]; //string de array
  series: number[]; //array de number 
}

const DonutChart = () => { //barra de rosca circular

  let chartData: ChartData = { labels: [], series: [] };
   axios.get(`${BASE_URL}/sales/amount-by-seller`)
   .then((response) => { 
      //função map converter a a lista de numeros da soma e de nomes dos vendedor
      const data = response.data as SaleSum[]; //array de salesum
      const myLabels = data.map(x => x.sellerName); //pega pra cada x do tipo do SaleSum dessa minha coleção original eu vou pegar somento o => x.sellername nome vendedor ai eu pego todos nomes eu crio uma nova listinha chamada myLabels para cada x do salesum eu vou levar pro x.sum e x.sellerName
      const mySeries = data.map(x => x.sum);
      chartData = { labels: myLabels, series: mySeries };

    console.log(chartData); //recebe a resposta . data
   }); 
  



 // const mockData = {
  //  series: [477138, 499928, 444867, 220426, 473088],
 //   labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
//}

const options = {
    legend: {
        show: true
    }
}
  return (
   
    <Chart options={{...options, labels: chartData.labels}}
           series={chartData.series}
           type="donut" //que é a rosca
           height="240"
    />
  );
}
export default DonutChart;