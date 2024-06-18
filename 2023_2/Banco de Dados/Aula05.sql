-- Tabelas
CREATE TABLE Corredores (
CorredorID INT PRIMARY KEY auto_increment,
Nome VARCHAR(50),
Idade INT,
Sexo CHAR(1),
Cidade VARCHAR(50),
Estado VARCHAR(2)
);
CREATE TABLE Corridas (
CorridaID INT PRIMARY KEY auto_increment,
Nome VARCHAR(100),
Data DATE,
Local VARCHAR(100),
Distancia DECIMAL(5, 2)
);
CREATE TABLE Inscricoes (
InscricaoID INT PRIMARY KEY auto_increment,
CorredorID INT,
CorridaID INT,
DataInscricao DATE,
FOREIGN KEY (CorredorID) REFERENCES Corredores (CorredorID),
FOREIGN KEY (CorridaID) REFERENCES Corridas (CorridaID)
);

-- Corredores
INSERT INTO Corredores (CorredorID, Nome, Idade, Sexo, Cidade, Estado)
VALUES
(1, 'Ana Silva', 28, 'F', 'São Paulo', 'SP'),
(2, 'João Oliveira', 35, 'M', 'Rio de Janeiro', 'RJ'),
(3, 'Mariana Santos', 24, 'F', 'Belo Horizonte', 'MG'),
(4, 'Carlos Souza', 42, 'M', 'Curitiba', 'PR');
-- Corridas
INSERT INTO Corridas (CorridaID, Nome, Data, Local, Distancia)
VALUES
(1, 'Corrida da Amizade', '2023-09-15', 'Parque Central', 10.5),
(2, 'Corrida da Liberdade', '2023-10-20', 'Parque dos Poetas', 8.7);
-- Inscricoes
INSERT INTO Inscricoes (InscricaoID, CorredorID, CorridaID, DataInscricao)
VALUES
(1, 1, 1, '2023-08-20'),
(2, 2, 1, '2023-08-25'),
(3, 3, 2, '2023-09-05'),
(4, 4, 2, '2023-09-10');

1- Crie uma Stored Procedure para inserir um novo corredor no banco de dados.

DELIMITER //

CREATE PROCEDURE inserirCorredor(
IN pNome VARCHAR(50),
    IN pIdade VARCHAR(50),
    IN pSexo CHAR(1),
    IN pCidade VARCHAR(50),
    IN pEstado VARCHAR(2)
)
BEGIN
INSERT INTO corredores(Nome, Idade, Sexo, Cidade, Estado)
    VALUES (pNome, pIdade, pSexo, pCidade, pEstado);
END

//
DELIMITER 

CALL inserirCorredor('José', 35, 'M', 'São Paulo', 'SP')

2 - Crie uma Stored Procedure para atualizar os detalhes de uma corrida.

DELIMITER //

CREATE PROCEDURE atualizarCorrida(
IN pCorredorID INT,
IN pNome VARCHAR(100),
    IN pData DATE,
    IN pLocal VARCHAR(100),
    IN pDistancia DECIMAL(5, 2)
)
BEGIN
UPDATE Corridas 
SET Nome = pNome, Data = pData, Local = pLocal, Distancia = pDistancia
WHERE CorredorID = pCorredorID;
END
//
DELIMITER 

CALL atualizarCorrida(1, 'Corrida de Rua', '2023-09-15', 'Praia Grande', 34.39)
 
 

3 - Crie uma Stored Procedure para excluir um corredor pelo seu ID.
 

DELIMITER //

CREATE PROCEDURE removerCorredor(
IN pCorredorId INT
)
BEGIN
DELETE FROM Inscricoes WHERE CorredorID = pCorredorId;

DELETE FROM corredores WHERE CorredorID = pCorredorId;
END
//
DELIMITER 

CALL removerCorredor(6);
 
 

4 - Crie uma Stored Procedure para buscar todos os corredores de uma determinada cidade.
 

DELIMITER //

CREATE PROCEDURE consultaCorredoresPorCidade(
IN pCidade VARCHAR(50)
)
BEGIN

SELECT * FROM corredores WHERE Cidade = pCidade;

END
//
DELIMITER 

CALL consultaCorredoresPorCidade('São Paulo')
 

5: Crie uma Stored Procedure para contar o número de corridas que ocorreram antes de uma determinada data.
 

DELIMITER //

CREATE PROCEDURE buscaCorridasPorData(
IN pData Date
)
BEGIN
SELECT COUNT(*) FROM corridas WHERE Data < pData;
END

//
DELIMITER 

CALL buscaCorridasPorData('2023-10-21')
 
 

6 - Crie uma Stored Procedure para registrar a inscrição de um corredor em uma corrida.

DELIMITER //

CREATE PROCEDURE criarInscricao(
IN pCorredorID INT,
    IN pCorridaID INT,
    IN pDataInscricao DATE
)
BEGIN
INSERT INTO Inscricoes(CorredorID, CorridaID, DataInscricao)
    VALUES(pCorredorID, pCorridaID, pDataInscricao);
END

//
DELIMITER 
 

CALL criarInscricao(7, 2, '2023-09-01')
 

7: Crie uma Stored Procedure para retornar o nome e a data das últimas 5 corridas

DELIMITER //

CREATE PROCEDURE retornarUltimas5Corridas(
IN pQuantity INT
)
BEGIN

SELECT Nome, Data FROM corridas ORDER BY Data DESC LIMIT pQuantity;

END
//
DELIMITER 
 

CALL retornarUltimas5Corridas(5)
 