import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {
    //n precisa parametizar pq vai ser um numero ent deixa so de valor 0 inicial
    const [activePage, setActivePage] = useState(0);

    const [page, setPage] = useState<SalePage>({ 
        first: true, //primeira pagina
        last: true,  //ultima pagina 
        number: 0, //numeor pagina 0
        totalElements: 0, //elementos 0
        totalPages: 0 //pagina 0

    });
   
     useEffect(() => { //vamos passar nossa ativação de pagina aqui onde era o numero da página
        axios.get(`${ BASE_URL}/sales?page=${activePage}&size=20sort=date,desc`)
        .then(response =>  {
            setPage(response.data); 
        }) 

     }, [activePage]) //ta observado o activePage

    
     const changePage = (index: number) => {
         
        setActivePage(index); 
     }

  return (
      <>
      <Pagination page={page} onPageChange={changePage} />
    <div className="table-responsive">
    <table className="table table-striped table-sm">
        <thead>
            <tr>
                <th>Data</th>
                <th>Vendedor</th>
                <th>Clientes visitados</th>
                <th>Negócios fechados</th>
                <th>Valor</th>
            </tr>
        </thead>
        <tbody>
            {page.content?.map(item => (
                <tr key={item.id}>
                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                <td>{item.seller.name}</td>
                <td>{item.visited}</td>
                <td>{item.deals}</td>
                <td>{item.amount.toFixed(2)}</td>
            </tr>
            )) }
            
           
        </tbody>
    </table>
 </div>

  </>
    );
}
export default DataTable;
