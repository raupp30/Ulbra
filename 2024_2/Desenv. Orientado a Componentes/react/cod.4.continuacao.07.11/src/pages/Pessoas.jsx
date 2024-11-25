import React from 'react';

const Pessoas = ({ pessoas }) => {
    return (
        <div>
            <h2>Lista de Pessoas Cadastradas</h2>
            {pessoas.length > 0 ? (
                <ul>
                    {pessoas.map((pessoa, index) => (
                        <li key={index}>
                            <strong>Nome:</strong> {pessoa.nome} <br />
                            <strong>Email:</strong> {pessoa.email} <br />
                            <strong>Telefone:</strong> {pessoa.telefone}
                        </li>
                    ))}
                </ul>
            ) : (
                <p>Nenhuma pessoa cadastrada ainda.</p>
            )}
        </div>
    );
};

export default Pessoas;