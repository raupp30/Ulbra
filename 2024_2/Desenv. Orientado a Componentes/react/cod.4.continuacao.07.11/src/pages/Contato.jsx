// Contato.js
import React, { useState } from 'react';

const Contato = ({ adicionarPessoa }) => {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [telefone, setTelefone] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        // Cria um objeto com os dados da pessoa
        const novaPessoa = { nome, email, telefone };
        // Adiciona a pessoa ao array
        adicionarPessoa(novaPessoa);
        // Limpa os campos após o envio
        setNome('');
        setEmail('');
        setTelefone('');
    };

    return (
        <div>
            <h2>Formulário de Contato</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Nome:</label>
                    <input 
                        type="text" 
                        value={nome} 
                        onChange={(e) => setNome(e.target.value)} 
                        required 
                    />
                </div>
                <div>
                    <label>Email:</label>
                    <input 
                        type="email" 
                        value={email} 
                        onChange={(e) => setEmail(e.target.value)} 
                        required 
                    />
                </div>
                <div>
                    <label>Telefone:</label>
                    <input 
                        type="tel" 
                        value={telefone} 
                        onChange={(e) => setTelefone(e.target.value)} 
                    />
                </div>
                <button type="submit">Cadastrar</button>
            </form>
        </div>
    );
};

export default Contato;
