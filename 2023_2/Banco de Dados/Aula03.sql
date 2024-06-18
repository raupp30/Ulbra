-- Criação da tabela Autores
CREATE TABLE Autores (
AutorID INT PRIMARY KEY,
NomeAutor VARCHAR(50)
);
-- Inserção de dados na tabela Autores
INSERT INTO Autores (AutorID, NomeAutor)
VALUES
(1, 'Autor 1'),
(2, 'Autor 2'),
(3, 'Autor 3');
-- Criação da tabela Livros
CREATE TABLE Livros (
LivroID INT PRIMARY KEY,
Titulo VARCHAR(100),
AutorID INT,
FOREIGN KEY (AutorID) REFERENCES Autores(AutorID)
);
-- Inserção de dados na tabela Livros
INSERT INTO Livros (LivroID, Titulo, AutorID)
VALUES
(101, 'Livro 1', 1),
(102, 'Livro 2', 1),
(103, 'Livro 3', 2),
(104, 'Livro 4', 3);

1- Crie uma view que mostra os detalhes dos livros

CREATE VIEW detalhesLivros
SELECT * FROM Livros l
JOIN Autores USING(AutorID)

SELECT * FROM detalhesLivros

2 - Crie uma view que mostra o número de livros por autor

CREATE VIEW AutoresQuantidadeLivros  AS
SELECT Autores.NomeAutor, COUNT(Livros.LivroID) AS quantidadeLivros FROM Autores
JOIN Livros ON Autores.AutorID = Livros.AutorID
GROUP BY Autores.AutorID
ORDER BT quantidadeLivros DESC LIMIT 1

SELECT * FROM AutoresQuantidadeLivros

3 - Crie uma view que mostra os livros de um autor específico

CREATE VIEW UserEspecifico
SELECT * FROM detalhesLivros WHERE AutorID = 2

SELECT * FROM UserEspecifico

4 - Criar uma View de Títulos Únicos de Livros

CREATE VIEW TitulosUnicos AS
SELECT DISTINCT(Titulo) FROM Livros

SELECT * FROM TitulosUnicos

5 - Criar uma View de Livros com Título Maior que N Caracteres

CREATE VIEW TituloMaior AS
SELECT * FROM Livros
WHERE char_lenght(Titulo) > 15