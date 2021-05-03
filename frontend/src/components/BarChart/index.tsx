import Chart from 'react-apexcharts';
const BarChat = () => { //barra de chat 
  //posso colcoar uma lógica de javascript antes do retorno
  const options = {
    plotOptions: {
        bar: {
            horizontal: true, //que ela é horizontal
        }
    },
};

const mockData = {
    labels: {  //categorias da barra grafico
        categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    },
    series: [
        {    //suas porcentagem
            name: "% Sucesso",
            data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
        }
    ]
};
  return (
    //parametros do meu chart , referenciando as variaveis acima
    //... pega tudo que tem no options e reaproveita
    //xaxis eixo x parametros dele do mockData
    <Chart options={{...options, xaxis: mockData.labels}}
           series={mockData.series}
           type="bar" //typo gráfico de barras
           height="240"//altura padrão de 240
    />
  );
}
export default BarChat;