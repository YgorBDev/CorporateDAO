DROP DATABASE IF EXISTS bd_integrador; 
CREATE DATABASE bd_integrador; 
USE bd_integrador;

CREATE TABLE empresa (
    id_empresa INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    nomeEmpresa VARCHAR(255) NOT NULL,
    cnpj CHAR(15) NOT NULL UNIQUE,
    lugar VARCHAR(255),
    dataCriacao VARCHAR(255),
    qtdeFuncionario DOUBLE, 
    lucroBruto DOUBLE, 
    lucroLiquido DOUBLE, 
    imposto DOUBLE
);

CREATE TABLE funcionario (
    id_funcionario INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    id_empresa INT,
    nome_funcionario VARCHAR(50) NOT NULL,
    cpf CHAR(14) NOT NULL UNIQUE,
    valor_imposto DOUBLE,
    data_nasc VARCHAR(50) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario DOUBLE NOT NULL,  
    celular VARCHAR(15) NOT NULL,     
    data_admissao VARCHAR(15) NOT NULL,
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
