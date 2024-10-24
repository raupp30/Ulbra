import React, { useState } from 'react';
import './formsCadastro.css';

const FormCadastro = (props) => {
    const [nome, setNome] = useState('');
    const [telefone, setTelefone] = useState('');
    const [egresso, setEgresso] = useState('não');
    const [pago, setPago] = useState('não');
    const [foto, setFoto] = useState('');
    const [cadastros, setCadastros] = useState([]);


    // funcao para tratar o envio do form
    const handleSubmit = (e) => {
        e.preventDefault();

        //valida se os campos do form estao preenchidos
        if (nome.trim() === '' || telefone.trim() === '' || foto.trim() === '') return;


        //cria um novo objeto de cadastro c os dados coletados
        const novoCadastro = {
            nome,
            telefone,
            egresso: egresso === 'sim' ? 'Egresso/Convidado' : 'Estudante',
            pago: pago === 'sim' ? 'Confirmado' : 'Não confirmado',
            foto,
        };


        //atualiza a lista, add um novo cadastro e ordenando alfabeticamente
        setCadastros((prevCadastros) => {
            const novosCadastros = [...prevCadastros, novoCadastro];
            return novosCadastros.sort((a, b) => a.nome.localeCompare(b.nome));
        });


        //reseta os campos apos envio
        setNome('');
        setTelefone('');
        setEgresso('não');
        setPago('não');
        setFoto('');
    };

    return (
        <div className='divCadastro'>
            <h2>Seja bem-vindo, {props.name}!</h2>
            <h2>Cadastro de Pessoas </h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
                    placeholder="Digite o nome"
                    required
                />
                <input
                    type="text"
                    value={telefone}
                    onChange={(e) => setTelefone(e.target.value)}
                    placeholder="Digite o telefone"
                    required
                />
                <label>
                    Egresso/Convidado:
                    <select value={egresso} onChange={(e) => setEgresso(e.target.value)} required>
                        <option value="não">Não</option>
                        <option value="sim">Sim</option>
                    </select>
                </label>
                <label>
                    Pago:
                    <select value={pago} onChange={(e) => setPago(e.target.value)} required>
                        <option value="não">Não</option>
                        <option value="sim">Sim</option>
                    </select>
                </label>
                <input
                    type="text"
                    value={foto}
                    onChange={(e) => setFoto(e.target.value)}
                    placeholder="URL da Foto"
                    required
                />
                <button type="submit">Cadastrar</button>
            </form>

            <h2>Lista de Pessoas Cadastradas:</h2>
            <div className="cards">
                {cadastros.map((cadastro, index) => (
                    <div className="card" key={index}>
                        <img src={cadastro.foto} alt={cadastro.nome} style={{ width: '100px', height: '100px', borderRadius: '50%' }} />
                        <p><strong>Nome:</strong> {cadastro.nome}</p>
                        <p><strong>Telefone:</strong> {cadastro.telefone}</p>
                        <p><strong>Status:</strong> {cadastro.egresso}</p>
                        <p><strong>Pagamento:</strong> {cadastro.pago}</p>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default FormCadastro;
