-- criação da tabela alunos
CREATE TABLE alunos (
    id_aluno INT PRIMARY KEY,
    nome VARCHAR(50),
    idade INT,
    curso VARCHAR(50)
);

-- inserindo dados na tabela alunos
INSERT INTO alunos VALUES
(1, 'João', 20, 'Engenharia'),
(2, 'Maria', 22, 'Ciência da Computação'),
(3, 'Carlos', 21, 'Medicina');

-- criação da tabela notas com chave estrangeira referenciando a table alunos
CREATE TABLE notas (
    id_aluno INT,
    disciplina VARCHAR(50),
    nota INT,
    FOREIGN KEY (id_aluno) REFERENCES alunos(id_aluno)
);

-- inserindo dados na tabela notas
INSERT INTO notas VALUES
(1, 'Matemática', 85),
(1, 'Física', 78),
(2, 'Matemática', 92),
(2, 'Física', 88),
(3, 'Matemática', 75),
(3, 'Física', 80);

-- crição da view --
CREATE VIEW vw_notas_alunos AS
SELECT a.nome AS Nome_Aluno, n.disciplina AS Disciplina, n.nota AS Nota
FROM alunos a
INNER JOIN notas n ON a.id_aluno = n.id_aluno;

-- consulta --

SELECT * FROM vw_notas_alunos;
