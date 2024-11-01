DROP DATABASE IF EXISTS bd_integrador; 
CREATE DATABASE bd_integrador; 
USE bd_integrador;

CREATE TABLE empresa (
    idEmpresa DOUBLE PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
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
    idFuncionario DOUBLE PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    idEmpresa DOUBLE,
    nomeFuncionario VARCHAR(50) NOT NULL,
    cpf CHAR(14) NOT NULL UNIQUE,
    valorImposto DOUBLE,
    dataNasc VARCHAR(50) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario DOUBLE NOT NULL,  
    celular VARCHAR(15) NOT NULL,     
    dataAdmissao VARCHAR(15) NOT NULL,
    FOREIGN KEY (idEmpresa) REFERENCES empresa(idEmpresa) ON DELETE CASCADE
);

CREATE TABLE imposto (
    idImposto DOUBLE PRIMARY KEY NOT NULL AUTO_INCREMENT UNIQUE,
    idEmpresa DOUBLE,
    valor DOUBLE NOT NULL,
    ano INT NOT NULL,
    dataDeclaracao VARCHAR(15) NOT NULL,
	FOREIGN KEY (idEmpresa) REFERENCES empresa(idEmpresa) ON DELETE CASCADE
);

select*from empresa;
select*from funcionario;
select*from imposto;


