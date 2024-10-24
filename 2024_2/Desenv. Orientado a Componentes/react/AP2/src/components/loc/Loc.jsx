import React, { useState, useEffect } from 'react';
import './Loc.css';

const Loc = () => {
    const [dataCep, setDataCep] = useState({});
    const [showData, setShowData] = useState(true);


    // useEffect para buscar os dados do cep quando o componente é montado
    useEffect(() => {
        async function getDataCep() {
            const dataJson = await fetch("https://viacep.com.br/ws/04220002/json/"); // faz a requisição para a api
            const cep = await dataJson.json(); //converte p/ json
            setDataCep(cep); //atualiza o estado
        }
        getDataCep(); // chama a func. para buscar os dados
    }, []); // o array vazio significa que isso será executado apenas uma vez após a montagem


    // func. para alterar a visibilidade dos dados
    const toggleDataVisibility = () => {
        setShowData(prev => !prev); // alterna o estado de visibilidade
    }

    return (
        <div className="loc-container">
            <button className="loc-button" onClick={toggleDataVisibility}>
                {showData ? "Esconder Dados" : "Mostrar Dados"}
            </button>
            <h3>CEP - {showData ? dataCep.cep : ''}</h3>
            <h3>CIDADE - {showData ? dataCep.localidade : ''}</h3>
            <h3>BAIRRO - {showData ? dataCep.bairro : ''}</h3>
            <h3>AV/RUA - {showData ? dataCep.logradouro : ''}</h3>
            <h3>HORÁRIO - {showData ? "16:00" : ''}</h3>
        </div>
    );
}

export default Loc;
