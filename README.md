# Projeto de Laboratório de Engenharia de Software

Esse projeto visa a criação de uma api web para um sistema de controle de estoque. O sistemas está dividido nas camadas de visualização, controle, entidade, modelo e serviços.

### Integrantes do grupo 

* Thiago Henrique da Silva
* Vitor Martinelli Lobo
* Flavio Ribeiro

### Professor

* **ANTONIO RODRIGUES CARVALHO**

### BD Schema
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
