import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

function App() {
    const [pessoas, setPessoas] = useState([]);

    function adicionarPessoa(pessoa) {
        setPessoas([...pessoas, pessoa]);
    }

    return (
      <Router>
      <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/sobre" component={Sobre} />
          <Route path="/contato">
              <Contato adicionarPessoa={adicionarPessoa} />
          </Route>
          <Route path="/pessoas">
              <Pessoas pessoas={pessoas} />
          </Route>
      </Switch>
      </Router>
    );
}

export default App;
