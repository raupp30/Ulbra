-- a) Obter o nome dos clientes que fizeram pelo menos um pedido com valor acima de R$ 200,00.

SELECT cli.nomeCliente FROM clientes AS cli
WHERE cli.idCliente IN (SELECT idCliente FROM pedidos WHERE valorPedido > 200)
 - - - - - - - - - 
SELECT nomeCliente FROM clientes 
INNER JOIN pedidos ON clientes.idCliente = pedidos.idCliente
WHERE pedidos.valorPedido > 200
 
 

-- b) Obter o nome das cidades que têm clientes com idade média superior a 28 anos.

SELECT nomeCidade FROM cidades 
INNER JOIN clientes ON clientes.idCidade = cidades.idCidade
GROUP BY cidades.idCidade
HAVING AVG(clientes.idadeCliente) > 28
 

-- c) Obter o nome dos clientes que fizeram pedidos em todas as cidades disponíveis na tabela “Cidades".
 

SELECT nomeCliente 
FROM clientes
WHERE idCliente IN (
SELECT idCliente
    FROM pedidos
    GROUP BY idCliente
    HAVING COUNT(DISTINCT idCidade) > 
(SELECT COUNT(*) FROM cidades)
);
 

-- d) Obter o nome das cidades que têm clientes que fizeram pedidos em datas diferentes.
 

SELECT nomeCidade FROM cidades
WHERE idCidade IN (
SELECT clientes.idCidade 
FROM clientes 
JOIN pedidos ON clientes.idCliente = pedidos.idCliente
GROUP BY clientes.idCidade
HAVING COUNT(DISTINCT dataPedido) > 1
)
 

-- e) Obter o nome dos clientes que têm o valor médio de pedidos maior que R$ 150,00.

SELECT nomeCliente 
FROM Clientes
JOIN Pedidos ON Clientes.idCliente = Pedidos.idCliente
GROUP BY pedidos.idCliente 
HAVING AVG(valorPedido) > 250


-- f) Obter o nome das cidades que têm clientes que fizeram pedidos em mais de um mês.

SELECT nomeCidade FROM cidades
WHERE idCidade IN(
    
    SELECT clientes.idCidade FROM clientes
    JOIN pedidos ON clientes.idCliente = pedidos.idadeCliente
    GROUP BY clientes.idCidade
    HAVING COUNT(DISTINCT MONTH (pedido.dataPedido)) > 1
);

-- g) Obter o nome dos clientes que fizeram mais de três pedidos.

SELECT nomeCliente FROM clientes
WHERE idCliente IN (
    SELECT idCliente FROM Pedidos
    GROUP BY idCliente
    HAVING COUNT(idPedido) > 3
)

-- h) Obter o nome das cidades que têm clientes com idade entre 25 e 35 anos.

SELECT nomeCidade FROM cidades
WHERE idCidade IN(
    SELECT idCidade FROM Clientes
    WHERE idadeCliente >= 5 AND idadeCliente < 35
)