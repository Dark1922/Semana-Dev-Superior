import axios from "axios";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {
    const [page, setPage] = useState<SalePage>({ 
        first: true, //primeira pagina
        last: true,  //ultima pagina 
        number: 0, //numeor pagina 0
        totalElements: 0, //elementos 0
        totalPages: 0 //pagina 0

    });
   
     useEffect(() => { //só qnd a página carregar
        //pagina 0 cada pagina tem 20 size elementos , e está decrescente 10 9 8 algo assim
        axios.get(`${ BASE_URL}/sales?page=0&size=20sort=date,desc`)
        .then(response =>  {//se deu certo vou atribuir essa resposta no meu page do useSatate page
            setPage(response.data); //pego o corpo da resposta e jogo no page
        }) 

     }, []) //[] niguem tá sendo observado ainda

  return (
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
    );
}
export default DataTable;
//contente é a lista  de Sale vai pegar o meu objeto page no campo content vou colocar interrogação porque eu vou fazer assim se o contente estiver definido ele valer uma lista de verdade  ai sim eu vou chamar dentro dele  o .map  pra cada objeto que eu um i ou x  eu vou retornar o bloquinho do tr , podemos dar qualquer nome mas botamos item pra ficar mais entendivel// qnd vc está renderizando um coleção vc tem que colocar um id ent temos que por o "key" no tr da tabela  que vai passar um id unico para cada coleção