---

# 📊 **DAO: Sistema para Cadastro de Empresa e Gestão Financeira**

Bem-vindo ao **DAO**, um sistema completo para cadastro de empresas, gestão de funcionários, declaração de impostos e organização financeira. Este projeto foi desenvolvido em **Java** e utiliza um banco de dados **MySQL** para armazenar as informações. Ele é ideal para gestores e administradores que desejam gerenciar empresas, funcionários e impostos de forma eficiente.

---

## 🚀 **Funcionalidades**

### **1. Cadastro de Empresas**
- Cadastre novas empresas com informações como:
  - Nome da empresa.
  - CNPJ.
  - Localização.
  - Data de criação.
  - Quantidade de funcionários.
  - Lucro bruto e líquido.

### **2. Gestão de Funcionários**
- Cadastre funcionários vinculados a uma empresa, com detalhes como:
  - Nome.
  - CPF.
  - Cargo.
  - Salário.
  - Data de nascimento.
  - Data de admissão.

### **3. Declaração de Impostos**
- Declare impostos para cada empresa, informando:
  - Ano de referência.
  - Valor do imposto.
  - Data de declaração.

### **4. Operações de Consulta e Edição**
- Consulte, edite ou exclua empresas, funcionários e declarações de impostos.
- Busque empresas e funcionários por nome ou parte do nome.
- Busque declarações de impostos pelo ID da empresa.

### **5. Interface de Linha de Comando (CLI)**
- Interface simples e intuitiva para interação com o sistema via terminal.

---

## 🛠 **Tecnologias Utilizadas**

- **Linguagem:** Java
- **Banco de Dados:** MySQL
- **Bibliotecas:** JDBC (Java Database Connectivity)
- **Ferramentas:** Git, Maven

---

## 📂 **Estrutura do Projeto**

```
dao-sistema/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── apresentacao/
│   │   │   │   └── Main.java          # Classe principal com a interface de linha de comando
│   │   │   ├── model/
│   │   │   │   ├── Empresa.java       # Modelo de empresa
│   │   │   │   ├── Funcionario.java   # Modelo de funcionário
│   │   │   │   └── Imposto.java       # Modelo de imposto
│   │   │   └── persistencia/
│   │   │       ├── EmpresaDAO.java    # DAO para operações com empresas
│   │   │       ├── FuncionarioDAO.java # DAO para operações com funcionários
│   │   │       └── ImpostoDAO.java    # DAO para operações com impostos
│   │   └── resources/
│   │       └── application.properties # Configurações do banco de dados
├── pom.xml                            # Dependências Maven
└── README.md                          # Este arquivo
```

---

## 🎯 **Como Executar o Projeto**

### **Pré-requisitos**
- Java 17 ou superior.
- MySQL instalado e configurado.
- Maven instalado.

### **Passos para Execução**
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/dao-sistema.git
   ```
2. Configure o banco de dados:
   - Crie um banco de dados MySQL chamado `dao_sistema`.
   - Atualize as credenciais no arquivo `application.properties`.

3. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="apresentacao.Main"
   ```

4. Siga as instruções no terminal para interagir com o sistema.

---

## 📝 **Exemplos de Uso**

### **Cadastro de Empresa**
- **Opção 1:** Cadastrar uma nova empresa.
- **Entrada:**
  ```
  Nome da empresa: Tech Solutions
  CNPJ: 12.345.678/0001-99
  Localização: São Paulo
  Data de criação: 2020-01-01
  Quantidade de funcionários: 50
  Lucro bruto: 1000000.00
  Lucro líquido: 800000.00
  ```

### **Cadastro de Funcionário**
- **Opção 5:** Cadastrar um novo funcionário.
- **Entrada:**
  ```
  ID da empresa: 1
  Nome: João Silva
  CPF: 123.456.789-00
  Cargo: Desenvolvedor
  Salário: 5000.00
  Data de nascimento: 1990-05-15
  Data de admissão: 2021-03-01
  ```

### **Declaração de Imposto**
- **Opção 9:** Declarar imposto para uma empresa.
- **Entrada:**
  ```
  ID da empresa: 1
  Ano: 2023
  Valor do imposto: 15000.00
  Data de declaração: 2023-04-15
  ```

---

## 📊 **Relatórios e Consultas**

- **Opção 2:** Listar todas as empresas cadastradas.
- **Opção 6:** Listar todos os funcionários cadastrados.
- **Opção 10:** Listar todas as declarações de impostos.
- **Opção 3:** Buscar empresa por nome.
- **Opção 7:** Buscar funcionário por nome.
- **Opção 11:** Buscar declarações de imposto por ID da empresa.

---

## 🤝 **Contribuição**

Contribuições são bem-vindas! Siga os passos abaixo:
1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

---

## 📄 **Licença**

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## ✉️ **Contato**

- **GitHub:** [github.com/YgorBDev](https://github.com/YgorBDev)
- **Email:** ygorb.dev@gmail.com

---
