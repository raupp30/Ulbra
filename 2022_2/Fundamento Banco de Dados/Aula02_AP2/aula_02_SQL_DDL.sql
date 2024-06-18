create table clientes
(
    id int not null primary key,
    nome varchar(100) not null,
    CPF char(14) not null unique
);

create table colaborador
(
    id int not null primary key,
    nome varchar(100) not null, 
    email varchar(100) not null,
    senha char(16), not null
);

create table projetos
(
   id int not null primary key,
   descricao varchar(300) not null,
   nome varchar(100) not null,
   duracao varchar (50) not null
);

create table comentario
(
    texto varchar(300),
    datat char(8)
);

create table social
(
    publico char(5)
);

create table departamento
(
   nome varchar(100) not null
);