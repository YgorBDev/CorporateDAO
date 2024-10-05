DROP DATABASE IF EXISTS bd_integrador; 
CREATE DATABASE bd_integrador; 
USE bd_integrador;

CREATE TABLE funcionario (
    id_funcionario BIGINT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    nome_funcionario VARCHAR(50) NOT NULL unique,
    cpf CHAR(14) NOT NULL UNIQUE,
    data_nasc DATE NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,  
    celular VARCHAR(15) NOT NULL unique,     
    data_admissao DATE NOT NULL,
    status ENUM('ativo', 'inativo') DEFAULT 'ativo'
);

CREATE TABLE empresa (
    id BIGINT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    nome_empresa VARCHAR(255) NOT NULL,
    cnpj CHAR(15) NOT NULL UNIQUE,
    lugar VARCHAR(255) NOT NULL unique,
    data_criacao DATE NOT NULL,
    lucro_bruto DECIMAL(15, 2) NOT NULL, 
    lucro_liquido DECIMAL(15, 2) NOT NULL, 
    imposto DECIMAL(15, 2) NOT NULL, 
    status ENUM('ativa', 'inativa') DEFAULT 'ativa'
);

CREATE TABLE imposto (
    id_imposto BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    id_empresa BIGINT,
    ano INT NOT NULL,
    valor_imposto DECIMAL(15, 2) NOT NULL, 
    data_declaracao DATE NOT NULL,
    FOREIGN KEY (id_empresa) REFERENCES empresa(id)
);

INSERT INTO funcionario (nome_funcionario, cpf, data_nasc, cargo, salario, celular, data_admissao, status) VALUES
('João Silva', '123.456.789-01', '1985-06-15', 'Gerente', 5000.00, '11987654321', '2020-01-10', 'ativo'),
('Maria Oliveira', '987.654.321-00', '1990-12-22', 'Analista', 3500.00, '11912345678', '2021-03-15', 'ativo'),
('Carlos Santos', '135.792.468-00', '1988-07-30', 'Desenvolvedor', 4000.00, '11999998888', '2022-05-20', 'ativo');

INSERT INTO empresa (nome_empresa, cnpj, lugar, data_criacao, lucro_bruto, lucro_liquido, imposto, status) VALUES
('Tech Solutions', '123.456/0001-95', 'São Paulo', '2015-04-01', 200000.00, 150000.00, 20000.00, 'ativa'),
('Consultoria ABC', '987.432/0001-96', 'Rio de Janeiro', '2018-08-15', 150000.00, 100000.00, 15000.00, 'ativa'),
('InovaCorp', '159.753/0001-97', 'Belo Horizonte', '2020-10-10', 80000.00, 50000.00, 8000.00, 'ativa');

INSERT INTO imposto (ano, valor_imposto, data_declaracao) VALUES
(2022, 20000.00, '2023-02-15'),
(2023, 22000.00, '2024-02-15'),
(2022, 15000.00, '2023-03-10'),
(2023, 16000.00, '2024-03-10'),
(2022, 8000.00, '2023-04-05'),
(2023, 8500.00, '2024-04-05');


SELECT * FROM empresa,funcionario,imposto;

