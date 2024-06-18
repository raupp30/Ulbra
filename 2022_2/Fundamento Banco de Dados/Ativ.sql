CREATE TABLE praticando_dml;

CREATE TABLE estudantes (
  id_estudante INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(40) NOT NULL,
  sobrenome VARCHAR(40)
);

CREATE TABLE aulas (
  id_aula INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(20) NOT NULL,
  descricao VARCHAR(60)
);

CREATE TABLE matricula (
  id_matricula INT AUTO_INCREMENT PRIMARY KEY,
  data_matricula DATE,
  id_estudante INT,
  id_aula INT,
  CONSTRAINT FK_ID_ESTUDANTE
    FOREIGN KEY (id_estudante) REFERENCES estudantes (id_estudante)
      ON DELETE RESTRICT
      ON UPDATE CASCADE,
  CONSTRAINT fk_id_aula
    FOREIGN KEY (id_aula) REFERENCES aulas (id_aula)
      ON DELETE RESTRICT
      ON UPDATE CASCADE
);

-- Inserts
INSERT INTO estudantes (id_estudante, nome, sobrenome)
  VALUES (1, "PAULO", "LIMA"),
         (2, "RAFAEL", "GOMES"),
         (3, "MARCOS", "SILVA"),
         (4, "JESSICA", "LIMA"),
         (5, "PAULO", "SILVA"),
         (6, "PAULO", "GOMES"),
         (7, "MARCOS", "SILVA"),
         (8, "MARCOS", "LIMA")

SELECT * FROM estudantes

INSERT INTO AULAS (ID_AULA, TITULO, DESCRICAO)
  VALUES (1, 'Banco de Dados','comandos ddls e dmls'),
         (2, 'Programacao', 'Java - classes e interfaces'),
         (3, 'Redes', 'Protocolos IPV6 e IPV4'),
         (4, 'Sistemas Operacional','Introducao ao linux')

SELECT * FROM aulas

INSERT INTO MATRICULAS (ID_MATRICULA, DATA_MATRICULA,ID_ESTUDANTE,ID_AULA)
  VALUES (1, '2022-01-10',1,4),
         (2, '2022-04-20',2,3),
         (3, '2022-03-15',3,2),
         (4, '2022-06-30',4,1),
         (5, '2022-01-15',5,4),
         (6, '2022-05-27',6,3),
         (7, '2022-03-10',7,2),
         (8, '2022-06-29',8,1)

SELECT * FROM matriculas

-- função de agregação (minimo 2. ex. Sum, count)
SELECT max(data_matricula) AS maior_data
  FROM matriculas

SELECT count(id_estudante) AS numero_de_estudantes
  FROM estudantes
    WHERE sobrenome like 'lima'

-- join
SELECT a.titulo, a.descricao, m.data_matricula
  FROM  aulas a INNER JOIN matriculas m ON a.id_aula = m.id_matricula
    ORDER BY a.titulo ASC;

-- group by
SELECT a.titulo, a.descricao, m.data_matricula
  FROM  aulas a INNER JOIN matriculas m ON a.id_aula = m.id_matricula
    GROUP BY a.id_aula > 2;

SELECT a.id_aula, a.titulo, m.data_matricula, e.nome AS nome_aluno, e.sobrenome, e.id_estudante AS numero_aluno
FROM  aulas a INNER JOIN matriculas m ON a.id_aula = m.id_matricula
    INNER JOIN estudantes e ON m.id_matricula = e.id_estudante
    GROUP BY e.nome DESC;

-- having
SELECT nome,sum(id_estudante) AS soma_ids_estudantes
  FROM ESTUDANTES 
    GROUP BY nome ASC
    HAVING soma_ids_estudantes > 12;