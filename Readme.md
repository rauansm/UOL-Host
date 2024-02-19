# UOL HOST

Aplicação criada para atender aos requisitos do teste para programador Java backend da UOL. Conforme descrito em https://github.com/uolhost/test-backEnd-Java

## 📑 Descrição
Este teste consiste em montar uma aplicação Java capaz de recuperar informações de um arquivo XML e de um arquivo JSON, persistir um cadastro em um banco de dados em memória ou em arquivo e listar os cadastros em uma interface simples.

## 💻 Como executar a aplicação
Você pode executar a aplicação da maneira que quiser e utilizando a IDE de sua preferência.

Caso queira executar a aplicação via linha de comando, execute primeiramente o comando:

             ./mvnw clean package  para linux.

             .\mvnw clean package  para windows.
Após isso execute o comando:
```bash     
               java -jar <caminhoParaSeuJar>
```
## 📂 Requisitos de sistema
- Possuir a JDK 11
- Uma IDE ou editor de sua preferência

## 🛠 Tecnologias Utilizadas:
- Java 11
- Spring Boot
- JUnit e Mockito
- Spring Web
- Spring Validation
- Log4j2
- Spring Data JPA
- Banco em memoria (H2 Database)
- Maven
- Lombok
- JAXB
