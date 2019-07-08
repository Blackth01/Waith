CREATE SCHEMA waith;

USE waith;


CREATE TABLE produto(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome TEXT NOT NULL,
    ingredientes TEXT,
    valor DECIMAL(6,2),
    FULLTEXT (nome)
);

CREATE TABLE numero(
	id INT PRIMARY KEY AUTO_INCREMENT,
    total DECIMAL(10,2)
);

CREATE TABLE pedido(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_produto INT,
    id_numero INT,
    quantidade INT,
    FOREIGN KEY (id_produto) REFERENCES produto(id),
    FOREIGN KEY (id_numero) REFERENCES numero(id)
);


