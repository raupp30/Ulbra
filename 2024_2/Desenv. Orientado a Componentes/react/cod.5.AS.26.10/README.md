Projeto CRUD de Produtos

Este projeto é uma aplicação web que permite realizar operações CRUD (Criar, Ler, Atualizar e Excluir) de produtos. Ele foi desenvolvido com o objetivo de prática em React, integrando uma API simulada usando o json-server.

Funcionalidades

Listar todos os produtos cadastrados.

Adicionar novos produtos com informações como nome, preço, descrição e URL da foto.

Editar os dados de produtos existentes.

Visualizar detalhes de um produto específico.

Excluir produtos.

Tecnologias Utilizadas

Front-end: React.js

Back-end Simulado: json-server

Estilização: CSS puro

Requisitos

Node.js instalado (v16 ou superior recomendado)

Gerenciador de pacotes npm ou yarn

Como Executar o Projeto

Passo 1: Clonar o Repositório

Clone o repositório do projeto para a sua máquina local:

git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

Passo 2: Instalar Dependências

Instale as dependências necessárias:

npm install
# ou
yarn install

Passo 3: Configurar o json-server

Inicie o servidor fake com os dados iniciais:

npx json-server --watch db.json --port 3001

O arquivo db.json contém os dados iniciais da aplicação.

O servidor estará disponível em: http://localhost:3001.

Passo 4: Iniciar o Projeto

Inicie a aplicação React:

npm start
# ou
yarn start

A aplicação estará disponível em: http://localhost:3000.

Estrutura do Projeto

/src: Contém todos os componentes React, páginas e estilos.

db.json: Arquivo usado pelo json-server para simular uma API REST.

Comandos Principais

Iniciar o servidor fake: npx json-server --watch db.json --port 3001

Iniciar o projeto React: npm start ou yarn start

Melhoria Futuras

Implementar autenticação de usuários.

Adicionar paginação na lista de produtos.

Melhorar a experiência do usuário com animações e feedback visual.
