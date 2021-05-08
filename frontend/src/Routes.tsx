import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import { BrowserRouter, Route, Switch } from "react-router-dom";

//vai esecificar as rotas do sistema
const Routes = () => { //dentro do switch vamos por algumas rotas path é o diretorio da rota "/" que seria a pagina home a pagina pricinpal exact pra dizer que a rota é exata e vamos por abaixo qual a rota que vamos colocar na barra que vai ser a página home
  return (

     <BrowserRouter>
       <Switch> 
         <Route path="/" exact>
              <Home />
        </Route>

        <Route path="/dashboard" >
              <Dashboard />
        </Route>
       </Switch>
     </BrowserRouter>

  );
}

export default Routes;