-- Comment

/*
Block comment
*/

-- Names?

/*
    tabelas plural
    atributos singular

    snake_case (usado no SQL)
    camelCase (JS)
    PascalCase (Outras lang)
    Abreviações emm letra Maiúscula
*/  

/*
Sintaxe para tabelas

create table nome_da_tabela
(
    nome_do_atributo | dominio | vazios | chaves,
    nome_do_atributo | dominio | vazios | chaves,
);

*/

create table clientes
(
    id int not null primary key,
    nome varchar(100) not null,
    CPF char(14) not null unique
);

create table enderecos
(
    id int not null primary key,
    logradouro varchar(100) not null,
    numero char(10),
    bairro varchar(100),
    cidade varchar(100),
    estado char(2),
    id_cliente int not null,
        constraint fk_clientes_enderecos
            foreign key(id_cliente) references clientes(id)
);

create table engenheiros
(
    id int not null primary key,
    nome varchar(100 not null
);

create table projetos
(
    id int not null primary key,
    nome varchar(100) not null
);

create table atuacoes
(
 id int not null primary key,
 funcao varchar(20),
 id_engenheiros int not null,
 id_projetos int not null,
 constraint fk_engenheiros_atuacoes  
 foreign key(id_engenheiros) references engenheiros(id),
 constraint fk_projetos_atuacoes
 foreign key(id_projetos) references projetos(id)
);


aluno(id, nome)
departamento (id, nome)
curso(id, nome, id_depto)
  id_depto referencia departamento (id)
professor(id, nome)
disciplina(id, nome, id_prof)
   id_prof referencia professor(id)
matricula(id_disciplina, id_aluno, data_matr)
    id_disciplina referencia disciplina(id) 
   id_aluno referencia aluno(id);
Auto incremento
sql server
id int identity(1,1)
postgres
id serial 
*/
CREATE TABLE alunos
(
    id INT auto_increment PRIMARY KEY,
    nome VARCHAR(80) not null
);

CREATE TABLE departamentos
(
    id INT auto_increment PRIMARY KEY,
    nome VARCHAR(30) not null
);

CREATE TABLE cursos
(
    id INT auto_increment PRIMARY KEY,
    nome VARCHAR(50) not null,
    id_departamento int not null,
    CONSTRAINT fk_cursos_departamentos 
        FOREIGN KEY (id_departamento)
            REFERENCES departamentos(id)
);

CREATE TABLE professores
(
    id INT auto_increment PRIMARY KEY,
    nome VARCHAR(80) not null
);

CREATE TABLE disciplinas
(    
    id INT auto_increment PRIMARY KEY,
    nome VARCHAR(30) not null,
    id_professor int not null,
    CONSTRAINT fk_disciplinas_professores
        FOREIGN KEY (id_professor)
            REFERENCES professores(id)
);

CREATE TABLE matriculas
(
    id int not null auto_increment primary key,
    data_matricula DATE,
    id_aluno INT not null,
    id_disciplina INT not null,

    CONSTRAINT fk_alunos_matriculas
        FOREIGN KEY (id_aluno)
            REFERENCES alunos(id),
            
    CONSTRAINT fk_disciplinas_matriculas
        FOREIGN KEY (id_disciplina)
            REFERENCES disciplinas(id)
);

-- diferença char e varchar
-- varchar aloca no sistema apenas o digitado pelo usuario.
-- char aloca no sistema quantos caracteres o admin colocou!