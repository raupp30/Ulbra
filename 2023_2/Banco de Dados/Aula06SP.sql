-- ATIVIDADE 01
-- criando trigger

CREATE TRIGGER AtualizarEstoque
AFTER INSERT ON Produtos
FOR EACH ROW
BEGIN

-- Definindo estoque 100

UPDATE Produtos
SET quantidade = 100
WHERE ProdutoID = new.ProdutoID
END;

-- ATIVIDADE 02
-- criando trigger

CREATE TRIGGER RegistrarExclusaoCliente
AFTER DELETE ON Clientes
FOR EACH ROW
BEGIN

-- INSERIR UM REGISTRO NA TABELA ClientesExcluidos com o nome do cliente

INSERT INTO ClientesExcluidos(nome)
VALUES(OLD.Nome)
END;

-- ATIVIDADE 03
-- criando STORE PROCEDURE

CREATE PROCEDURE AumentarSalario(IN FuncionarioID INT, IN ValorAumento DECIMAL(10 ,2))
-- ATUALIZAR SALARIO CONFORME VALOR DO AUMENTO

UPDATE Funcionarios
SET Salario = Salario + ValorAumento
WHERE FuncionarioID = FuncionarioID
END;


-- ATIVIDADE 04
-- CRIANDO STORE PROCEDURE

CREATE PROCEDURE InserirPedido(IN ClienteID INT, IN DataPedido DATE)
BEGIN
-- INSERIR UM NOVO PEDIDO
INSERT INTO Pedidos (ClienteID, DataPedido)
VALUES (ClientesID, DataPedido)
END;




