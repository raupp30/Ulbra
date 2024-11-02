import { useState } from "react";
import Header from "../components/header/Header";
import FormularioDePessoas from "../components/header/FormularioDePessoas";
import ListaDePessoas from "../components/ListaDePessoas";
import './Contato.css';

const Contato = () => {
    const [pessoas, setPessoas] = useState([]);

    const addPessoa = (pessoa) => {
        setPessoas([...pessoas, pessoa])
    };

    return (
        <>
        <Header />
        <div className="Contato-container">
        <h1>Contato</h1>
        <FormularioDePessoas addPessoa={addPessoa} />
        <ListaDePessoas pessoas={pessoas} />
        </div>
        </>
    );
}

export default Contato;