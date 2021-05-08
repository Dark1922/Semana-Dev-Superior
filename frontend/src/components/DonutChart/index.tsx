import Chart from 'react-apexcharts';
import axios from 'axios';
import { BASE_URL } from 'utils/requests';
import { SaleSum } from 'types/sale';
import { useEffect, useState } from 'react';

type ChartData = { //vamos criar um tipo parecido com interface
  labels: string[]; //string de array
  series: number[]; //array de number 
}

const DonutChart = () => { 
  const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] }); 

    useEffect(() => {
      
       axios.get(`${ BASE_URL }/sales/amount-by-seller`)
   .then((response) => { 
      
      const data = response.data as SaleSum[]; 
      const myLabels = data.map(x => x.sellerName); 
      const mySeries = data.map(x => x.sum);
      setChartData({ labels: myLabels, series: mySeries });

    
   }); 
    }, []);

  

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