CREATE TABLE socios (
  id_socio INT auto_increment PRIMARY KEY, 
  codigo_socio VARCHAR (10) NOT NULL,
  nome VARCHAR (50) NOT NULL,
  telefone VARCHAR (20) NOT NULL,
  endereco VARCHAR (100) NOT NULL,
  desc_tipo_socio VARCHAR (100) NOT NULL
);

CREATE TABLE servicos (
  id_servico INT auto_increment PRIMARY KEY, 
  codigo_servico VARCHAR (10) NOT NULL,
  descricao VARCHAR (200) NOT NULL,
  valor_servico DECIMAL (18.2) NOT NULL
);

CREATE TABLE pedidos_servicos (
  id_pedido INT auto_increment PRIMARY KEY,
  valor_pedido DECIMAL (18.2) NOT NULL,
  data_pedido DATE NOT NULL,
  id_socio INT,
  id_servico INT,
  CONSTRAINT socios_fk_pedidos_servicos
    FOREIGN KEY (id_socio) REFERENCES socios(id_socio)
    ON DELETE restrict
    ON UPDATE cascade,
  CONSTRAINT servicos_fk_pedidos_servicos
    FOREIGN KEY (id_servico) REFERENCES servicos(id_servico)
    ON DELETE restrict
    ON UPDATE cascade
);

-- socios

INSERT INTO socios(codigo_socio, nome, telefone, endereco, desc_tipo_socio)
  VALUES (345, 'Joao', '36649216','Av Barão do Rio Branco', 'Socio Diamond');

INSERT INTO socios(codigo_socio, nome, telefone, endereco, desc_tipo_socio)
  VALUES (678, 'Andre', '36649118','Av Higienopolis', 'Socio Gold');

INSERT INTO socios(codigo_socio, nome, telefone, endereco, desc_tipo_socio)
  VALUES (91011, 'Maria', '36649022','Av Ipiranga', 'Socio Silver');

SELECT * FROM socios;

-- serviços

INSERT INTO servicos(codigo_servico, descricao, valor_servico)
  VALUES (123, 'serviço de hidraulica', 300,);

INSERT INTO servicos(codigo_servico, descricao, valor_servico)
  VALUES (456, 'serviço de marcenaria', 2500,);

INSERT INTO servicos(codigo_servico, descricao, valor_servico)
  VALUES (789, 'serviço instalação eletrica', 1500,);

SELECT * FROM servicos;

-- pedidos_serviços

INSERT INTO pedidos_servicos(valor_pedido, data_pedido)
     VALUES (1500.00, '2020-02-29');
INSERT INTO pedidos_servicos(valor_pedido, data_pedido)
     VALUES (3500.00, '2020-04-16');
INSERT INTO pedidos_servicos(valor_pedido, data_pedido)
     VALUES (5500.00, '2020-12-24');

SELECT * FROM pedidos_servicos;

-- comandos

SELECT * FROM servicos WHERE valor_servico > 500;

SELECT * FROM pedidos_servicos WHERE data_pedido = '2020-01-03';

SELECT * FROM socios WHERE endereco = 'Rua Barão do Rio Branco';