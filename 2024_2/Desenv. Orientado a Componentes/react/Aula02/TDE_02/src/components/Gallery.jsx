import React from 'react';
import Profile from './Profile';


function Gallery({ title }) {

    const profile1 = {
        nome: "João",
        imagem: "https://i.imgur.com/szV5sdG.jpeg",
        profissao: "Dev",
        premios: ["Nenhum"],
        descobertas: ["Nenhum"]
    };


    const profile2 = {
        nome: "Pedro",
        imagem: "https://i.imgur.com/YfeOqp2.jpeg",
        profissao: "Eng. Soft",
        premios: ["Nenhum"],
        descobertas: ["Nenhum"]
    };


    return (
        <div>
            <h1>{title}</h1>
            <div style={styles.gallery}>
                <Profile data={profile1} />
                <Profile data={profile2} />
            </div>
        </div>
    );
}


const styles = {
    gallery: {
        display: 'block', // Altera para um bloco vertical, não flexbox
        width: '100%', // Faz a galeria ocupar toda a largura disponível
    }
};

export default Gallery;

