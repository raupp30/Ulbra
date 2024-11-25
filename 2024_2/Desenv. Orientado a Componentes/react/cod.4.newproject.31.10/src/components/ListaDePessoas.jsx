import React from 'react';

const ListaDePessoas = ({ pessoas }) => {
    return(
        <div>
        <h2>Pessoas cadastradas</h2>
        <ul>
            {pessoas.map((pessoa, index) => (
                <li key={index}>{pessoa.nome} - {pessoa.telefone}</li>
            ))}
        </ul>
        </div>
    )
}

export default ListaDePessoas;