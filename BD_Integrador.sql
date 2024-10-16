DROP DATABASE IF EXISTS bd_integrador; 
CREATE DATABASE bd_integrador; 
USE bd_integrador;

CREATE TABLE empresa (
    id_empresa INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    nome_empresa VARCHAR(255) NOT NULL,
    cnpj CHAR(15) NOT NULL UNIQUE,
    lugar VARCHAR(255) NOT NULL UNIQUE,
    data_criacao DATE NOT NULL,
    lucro_bruto DECIMAL(15, 2) NOT NULL, 
    lucro_liquido DOUBLE, 
    imposto DOUBLE, 
    qta_funcionario INT,
    status ENUM('ativa', 'inativa') DEFAULT 'ativa'
);

CREATE TABLE funcionario (
    id_funcionario INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    id_empresa INT,
    nome_funcionario VARCHAR(50) NOT NULL,
    cpf CHAR(14) NOT NULL UNIQUE,
    valor_imposto DOUBLE,
    data_nasc DATE NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,  
    celular VARCHAR(15) NOT NULL UNIQUE,     
    data_admissao DATE NOT NULL,
    status ENUM('ativo', 'inativo') DEFAULT 'ativo',
    FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa)
);

CREATE TABLE imposto (
    id_imposto INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    id_empresa INT,
    ano INT NOT NULL,
    imposto DOUBLE, 
    data_declaracao DATE NOT NULL
);

create table paga(
	id_paga INT PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    id_empresa INT,
    id_imposto INT,
	FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa),
	FOREIGN KEY (id_imposto) REFERENCES imposto(id_imposto)
);

select*from empresa;
select*from funcionario;
select*from imposto;
select*from paga;
