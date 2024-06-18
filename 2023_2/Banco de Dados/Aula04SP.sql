1 - -- Seleciona todos os produtos da categoria 'Eletrônicos'
SELECT product_name
FROM products
WHERE category_id = (
    SELECT category_id
    FROM categories
    WHERE category_name = 'Eletrônicos'
);

2 - -- Calcula o total de vendas por mês
SELECT MONTH(sale_date) AS month, YEAR(sale_date) AS year, SUM(sale_amount) AS total_sales
FROM sales
GROUP BY YEAR(sale_date), MONTH(sale_date)
ORDER BY year, month;

3 - -- Cria uma view para obter informações detalhadas das compras dos clientes
CREATE VIEW customer_purchase_info AS
SELECT c.customer_id, c.customer_name, o.order_id, o.order_date, oi.product_id, p.product_name
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN order_items oi ON o.order_id = oi.order_id
JOIN products p ON oi.product_id = p.product_id;

-- Consulta usando a view para obter detalhes da compra do cliente com ID 123
SELECT *
FROM customer_purchase_info
WHERE customer_id = 123;