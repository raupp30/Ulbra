CREATE TABLE pesquisadores (
    cod_pesquisadores int auto_increment PRIMARY KEY VARCHAR (10) NOT NULL,
    nome varchar(20)
);

CREATE TABLE artigos (
    cod_art int auto_increment PRIMARY KEY,
    Titulo varchar(20) not NULL,
    pag_inicial varchar(7) not NULL,
    pag_final varchar(7) not NULL,
    cod_periodico varchar(5) not NULL,
    titulo_periodico varchar(9) not NULL,
    editora varchar(20) not NULL
);



-- pesquisadores com joão

INSERT INTO pesquisadores(cod_pesquisadores, nome,)
  VALUES (1, 'Joao Vitor');

INSERT INTO pesquisadores(cod_pesquisadores, nome,)
  VALUES (444, 'Francisco');

INSERT INTO pesquisadores(cod_pesquisadores, nome,)
  VALUES (32, 'Pedro');

SELECT * FROM pesquisadores;

-- artigos editora saraiva

INSERT INTO artigos(cod_art, titulo, pag_inicial, pag_final, cod_periodico, titulo_periodico, editora )
  VALUES (1, 'Turma da mônica', '1', '85', '10', 'TM', 'Saraiva');

INSERT INTO artigos(cod_art, titulo, pag_inicial, pag_final, cod_periodico, titulo_periodico, editora )
  VALUES (1234, 'Halloween vem aí', '1', '5', '98', 'HVA', 'Globo');

INSERT INTO artigos(cod_art, titulo, pag_inicial, pag_final, cod_periodico, titulo_periodico, editora )
  VALUES (131, '2 meses para o Natal', '1', '8', '53', '2MPN', 'Record');

SELECT * FROM artigos;

-- codes

SELECT * FROM pesquisadores WHERE nome = João;

SELECT * FROM artigos WHERE editora = 'Saraiva';

SELECT * FROM artigos WHERE cod_art = '1234';
