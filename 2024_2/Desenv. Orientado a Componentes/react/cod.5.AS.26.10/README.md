<h1>Projeto CRUD de Produtos</h1>

    <p>Este projeto é uma aplicação web que permite realizar operações CRUD (Criar, Ler, Atualizar e Excluir) de produtos. Ele foi desenvolvido com o objetivo de prática em React, integrando uma API simulada usando o <code>json-server</code>.</p>

    <h2>Funcionalidades</h2>
    <ul>
        <li>Listar todos os produtos cadastrados.</li>
        <li>Adicionar novos produtos com informações como nome, preço, descrição e URL da foto.</li>
        <li>Editar os dados de produtos existentes.</li>
        <li>Visualizar detalhes de um produto específico.</li>
        <li>Excluir produtos.</li>
    </ul>

    <h2>Tecnologias Utilizadas</h2>
    <ul>
        <li><strong>Front-end</strong>: React.js</li>
        <li><strong>Back-end Simulado</strong>: json-server</li>
        <li><strong>Estilização</strong>: CSS puro</li>
    </ul>

    <h2>Requisitos</h2>
    <ul>
        <li>Node.js instalado </li>
        <li>Gerenciador de pacotes npm ou yarn</li>
    </ul>

    <h2>Como Executar o Projeto</h2>

    <h3>Passo 1: Clonar o Repositório</h3>
    <pre><code>git clone https://github.com/raupp30/Ulbra/blob/master/2024_2/Desenv.%20Orientado%20a%20Componentes/react/cod.5.AS.26.10/README.md

    <h3>Passo 2: Instalar Dependências</h3>
    <pre><code>npm install

    <h3>Passo 3: Configurar o json-server</h3>
    <pre><code>npx json-server --watch db.json --port 3001</code></pre>
    <ul>
        <li>O arquivo <code>db.json</code> contém os dados iniciais da aplicação.</li>
        <li>O servidor estará disponível em: <code>http://localhost:3001</code>.</li>
    </ul>

    <h3>Passo 4: Iniciar o Projeto</h3>
    <pre><code>npm start
# ou
yarn start</code></pre>
    <p>A aplicação estará disponível em: <code>http://localhost:3000</code>.</p>

    <h2>Estrutura do Projeto</h2>
    <ul>
        <li><strong>/src</strong>: Contém todos os componentes React, páginas e estilos.</li>
        <li><strong>db.json</strong>: Arquivo usado pelo <code>json-server</code> para simular uma API REST.</li>
    </ul>

    <h2>Comandos Principais</h2>
    <ul>
        <li><strong>Iniciar o servidor fake</strong>: <code>npx json-server --watch db.json --port 3001</code></li>
        <li><strong>Iniciar o projeto React</strong>: <code>npm start</code> ou <code>yarn start</code></li>
    </ul>

    <h2>Melhoria Futuras</h2>
    <ul>
        <li>Implementar autenticação de usuários.</li>
        <li>Adicionar paginação na lista de produtos.</li>
        <li>Melhorar a experiência do usuário com animações e feedback visual.</li>
    </ul>

