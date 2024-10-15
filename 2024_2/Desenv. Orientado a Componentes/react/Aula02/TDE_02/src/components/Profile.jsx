import React from 'react';

function Profile({ data }) {
    const { nome, imagem, profissao, premios, descobertas } = data;

    return (
        <div className="profile-card" style={styles.card}>
            <img src={imagem} alt={`${nome}'s avatar`} style={styles.avatar} />
            <h2>{nome}</h2>
            <p><strong>Profissão:</strong> {profissao}</p>

            <h3>Prêmios:</h3>
            <ul>
                {premios.map((premio, index) => (
                    <li key={index}>{premio}</li>
                ))}
            </ul>

            <h3>Descobertas:</h3>
            <ul>
                {descobertas.map((descoberta, index) => (
                    <li key={index}>{descoberta}</li>
                ))}
            </ul>
        </div>
    );
}

const styles = {
    card: {
        display: 'block', // Definindo display como block
        width: '100%', // O card agora vai ocupar toda a largura disponível
        border: '1px solid #ccc',
        borderRadius: '8px',
        padding: '16px',
        margin: '16px 0', // Margem para espaçar os cards verticalmente
        textAlign: 'left', // Alinhando o conteúdo à esquerda
        boxSizing: 'border-box', // Garante que padding e border sejam incluídos no width
    },
    avatar: {
        borderRadius: '50%',
        width: '150px',
        height: '150px',
        display: 'block',
        margin: '0 auto 16px auto', // Centraliza a imagem no bloco
    },
};

export default Profile;
