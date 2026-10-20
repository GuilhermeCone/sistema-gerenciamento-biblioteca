# Sistema de Gerenciamento de Biblioteca

API REST desenvolvida em Java com Spring Boot para gerenciar o cadastro, consulta, empréstimo e devolução de livros, utilizando PostgreSQL para persistência dos dados.

## Tecnologias utilizadas

- Java 27
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven

## Funcionalidades

- Cadastrar novos livros
- Listar todos os livros cadastrados
- Buscar livros por título
- Consultar livros por ID
- Registrar empréstimos de livros
- Registrar devoluções de livros
- Excluir livros
- Validar informações de cadastro

## Estrutura do projeto

```text
src/main/java/com/biblioteca/biblioteca/
├── BibliotecaApplication.java
├── controller/
│   └── LivroController.java
├── model/
│   └── Livro.java
├── repository/
│   └── LivroRepository.java
└── service/
    └── LivroService.java
```

O projeto utiliza uma arquitetura em camadas, separando o recebimento das requisições HTTP, as regras de negócio e o acesso ao banco de dados.

## Endpoints da API

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/livros` | Cadastrar um livro |
| GET | `/livros` | Listar todos os livros |
| GET | `/livros/{id}` | Buscar livro por ID |
| GET | `/livros/buscar?titulo=Duna` | Buscar por título |
| PUT | `/livros/{id}/emprestar` | Emprestar livro |
| PUT | `/livros/{id}/devolver` | Devolver livro |
| DELETE | `/livros/{id}` | Excluir livro |

## Exemplo de cadastro

Requisição:

**POST** `http://localhost:8080/livros`

Corpo JSON:

```json
{
  "titulo": "Duna",
  "autor": "Frank Herbert",
  "anoPublicacao": 1965
}
```

Exemplo de resposta:

```json
{
  "id": 1,
  "titulo": "Duna",
  "autor": "Frank Herbert",
  "anoPublicacao": 1965,
  "disponivel": true
}
```

## Como executar o projeto

### Pré-requisitos

- JDK 27
- PostgreSQL
- Maven (ou Maven Wrapper incluído no projeto)

### Configuração

1. Crie um banco PostgreSQL chamado `biblioteca_db`.
2. Configure o arquivo `src/main/resources/application.properties`:

```properties
spring.application.name=biblioteca
spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_db
spring.datasource.username=postgres
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Defina a variável de ambiente `DB_PASSWORD` com a senha do usuário PostgreSQL.
4. Execute a classe `BibliotecaApplication.java` pelo IntelliJ ou utilize o Maven Wrapper.

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Sobre o projeto

Este projeto foi desenvolvido para praticar programação orientada a objetos, criação de APIs REST, arquitetura em camadas e integração entre aplicações Java e bancos de dados relacionais.

O sistema começou como uma aplicação Java executada no terminal e posteriormente foi adaptado para uma API REST com Spring Boot.