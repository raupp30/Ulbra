CREATE TABLE clientes (
  id INT auto_increment UNIQUE PRIMARY KEY,
  cpf VARCHAR(50),
  nome VARCHAR(20) NOT NULL,
  sobrenome VARCHAR(20) NOT NULL,
  telefone VARCHAR (15),
  endereco VARCHAR (50)
);

CREATE TABLE carros (
  id INT auto_increment UNIQUE PRIMARY KEY,
  placa VARCHAR (10),
  modelo VARCHAR (10),
  cod_marca INT,
  marca VARCHAR (10),
  ano VARCHAR (10),
  data_aluguel VARCHAR (10),
  data_devolucao VARCHAR (10),
  valor DECIMAL (18.2)
);

CREATE TABLE alugueis (
  n_registro INT auto_increment UNIQUE PRIMARY KEY,
  data_aluguel DATE NOT NULL,
  data_devolucao DATE NOT NULL,
  valor DECIMAL (18.2)
);

CREATE TABLE tem (
  alugueis_fk_tem_carros INT,
  carros_fk_tem_alugueis INT,
  CONSTRAINT alugueis_fk_carros
    FOREIGN KEY (alugueis_fk_tem_carros) REFERENCES alugueis (n_registro)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT carros_fk_alugueis
    FOREIGN KEY (carros_fk_tem_alugueis) REFERENCES carros (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

CREATE TABLE contratam (
  alugueis_clientes INT,
  clientes_alugueis INT,
  CONSTRAINT alugueis_fk_clientes
    FOREIGN KEY (alugueis_clientes) REFERENCES alugueis (n_registro)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT clientes_fk_alugueis
    FOREIGN KEY (clientes_alugueis) REFERENCES clientes (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- Quais clientes que tem silva no nome?

INSERT INTO clientes (cpf, nome, sobrenome, telefone, endereco)
  VALUES ('345.978.768-09', 'Joao', 'Silva', '(51)98565-6352', 'Av Ipiranga, apto, n. 6');

SELECT * FROM clientes
  WHERE sobrenome = 'silva';

-- Quais carros foram locados no mês de setembro de 2021?

INSERT INTO alugueis (n_registro, data_aluguel, data_devolucao, valor)
  VALUES ('1', '2022-09-7', '2022-09-15', '765,70');

INSERT INTO alugueis (data_aluguel, data_devolucao, valor)
  VALUES ('2022-03-3', '2022-03-8', '600.00'),
  ('2022-09-7', '2022-09-15', '658.95');

SELECT * FROM alugueis
  WHERE data_aluguel BETWEEN '2022-09-01' AND '2022-09-30';

-- Faça uma atualização para acrescentar 20% nos valores dos aluguéis

SELECT valor, 
  valor * 1.20 AS mais_vinte_porcento
  FROM alugueis;
