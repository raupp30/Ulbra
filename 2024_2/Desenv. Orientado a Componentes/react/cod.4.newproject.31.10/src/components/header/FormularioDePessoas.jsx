import { useState } from "react";

const FormularioDePessoas = ({ addPessoa }) => {
    const [nome, setNome] = useState('');
    const [telefone, setTelefone] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        if (nome && telefone) {
            addPessoa({ nome, telefone });
            setNome('');
            setTelefone('');
        }
    };

    return(
        <form onSubmit={handleSubmit}>
            <input 
                type="text" 
                placeholder="Nome" 
                value={nome} 
                onChange={(e) => setNome(e.target.value)} 
                required 
            />
            <input 
                type="text" 
                placeholder="Telefone" 
                value={telefone} 
                onChange={(e) => setTelefone(e.target.value)} 
                required 
            />
            <button type="submit">Adicionar</button>
        </form>
    )
}

export default FormularioDePessoas;