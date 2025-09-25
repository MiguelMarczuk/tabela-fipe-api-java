# Projeto Tabela FIPE - Java + Spring Boot

Este projeto consome a **API da Tabela FIPE** para listar marcas, modelos e valores de veículos.
Foi desenvolvido como exercício de estudos em **Java 17**, **Spring Boot** e **Maven**.

## 🚀 Tecnologias
- Java 17+
- Spring Boot
- Maven
- Jackson (para desserialização JSON)
- API pública da Tabela FIPE


## 💻 Exemplo de execução

codigo da marca que voce quer consultar
> 59

modelos dessa marca:
codigo=5940, nome=Palio 1.0
codigo=5941, nome=Palio 1.6

digite um trecho do carro que vc gostaria de pesquisar
> palio

todos veiculos filtrados com avaliação por ano:
Veiculos{valor='R$ 25.000,00', marca='Fiat', modelo='Palio 1.0', ano=2018, tipoCombustivel='Flex'}
Veiculos{valor='R$ 27.000,00', marca='Fiat', modelo='Palio 1.6', ano=2019, tipoCombustivel='Flex'}




## ▶️ Como rodar o projeto

Clone o repositório:


```bash
git clone https://github.com/MiguelMarczuk/tabela-fipe-api-java.git

cd tabela-fipe-api-java
mvn spring-boot:run
