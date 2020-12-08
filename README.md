# Projeto de Programação Orientada a Objetos

Esse projeto visa a criação de um sistema de controle de estoque. A aplicação está dividido nas camadas de controle, entidade, modelo e serviços. Sendo o backend 100% voltado para construção de uma web api utlizando spring boot, e o frontend sendo uma SPA (single page application), construida com o react.

## Integrantes do grupo 

* Thiago Henrique da Silva
* Vitor Martinelli Lobo

## Professor

* **ANTONIO RODRIGUES CARVALHO**

### Como rodar o projeto
1. Clone o repositório e abra-o no eclipse
2. Espere as dependências do pom.xml serem instaladas
3. Crie em seu MySQL um banco de dados chamado 'estoque'
4. Coloque as credenciais (login e senha) do seu MySQL no arquivo application.properties
5. Inicie a aplicação a partir do arquivo StockSystemApplication.java
6. Coloque no seu navegador [http://localhost:8080/](http://localhost:8080/) 

### Tecnologias
* Banck-end: Spring Boot
* Front-end: React
* Data Base: MySQL

### DB Schema
![Image of Data Base Schema Diagram](https://raw.githubusercontent.com/thiago-hs/StockSystem/master/SCHEMA.png)

### Rotas

* **/**
* **/categorias**
* **/produtos**
* **/entradas**
* **/item-entradas**
* **/saidas**
* **/item-saidas**
* **/fornecedores**
* **/transportadoras**
* **/lojas**
* **/cidades**

### API

* **/api/categoria** (GET,POST)
* **/api/categoria/`<id>`** (GET,PUT,DELETE)

* **/api/produto** (GET,POST)
* **/api/produto/`<id>`** (GET,PUT,DELETE)

* **/api/entrada** (GET,POST)
* **/api/entrada/`<id>`** (GET,PUT,DELETE)
* **/api/entrada/`<productId>`** (GET)

* **/api/saida** (GET,POST)
* **/api/saida/`<id>`** (GET,PUT,DELETE)
* **/api/saida/`<productId>`** (GET)

* **/api/fornedor** (GET,POST)
* **/api/fornedor/`<id>`** (GET,PUT,DELETE)

* **/api/transportadora** (GET,POST)
* **/api/transportadora/`<id>`** (GET,PUT,DELETE)

* **/api/loja** (GET,POST)
* **/api/loja/`<id>`** (GET,PUT,DELETE)

* **/api/cidade** (GET,POST)
* **/api/cidade/`<id>`** (GET,PUT,DELETE)

> Todos os GET terão todas as propriedades previstas no banco, em caso de um id específico apenas o registro dessa chave será retornado, caso contrário todos registros devem ser retornados, em caso de alguma propriedade ser um chave estranjeira o nome da referência também tem que ser fornecido; os POST receberão todos os propriedades previstas no banco menos a chave primária; os PUT receberão o objeto completo com os dados que já existiam mais o(s) dado(s) que foi alterado, tudo no mesmo objeto; já os DELETE apenas receberão o id da entidade.
