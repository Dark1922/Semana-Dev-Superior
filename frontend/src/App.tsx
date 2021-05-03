import DonutChart from "components/DonutChart";
import BarChat from "components/BarChart";
import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

//col-sm-6 usa um expaço de grande de 6 unidade
//px-3 um expaçamento padding no eixo x de 3 unidades horizontal , py vertical de 3
function App() {//classe row do bootstrap vai organizar os componentes em uma linha
  return (
    <>
  <NavBar/>

  <div className="container">

    <h1 className="text-primary py-3">Dashboard de Vendas</h1>

    <div className="row px-3">
      <div className="col-sm-6">
      <h5 className="text-center">Taxas de sucesso(%)</h5>
        <BarChat />
      </div>
      <div className="col-sm-6">
        <h5 className="text-center">Todas as vendas</h5>
        <DonutChart />
      </div>
      </div> 
      <div className="py-3">
      <h2 className="text-primary">Todas as vendas</h2>
      </div>

    <DataTable />
  </div>

  <Footer />

  </>
  );
} 

export default App;
