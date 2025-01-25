# DSList (Java Spring Web API RESTful)

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

Este projeto é uma aplicação Spring Web API RESTful desenvolvida em Java, que utiliza PostgreSQL como banco de dados. O sistema foi criado para exibir listas de jogos e categorizá-los.

![Diagrama das Entidades do Projeto](.\docs\diagram.svg)

<small>
Diagrama de Entidade-Relacionamento do Projeto
</small>

## 💻 Descrição

O `DSList` é um sistema de gerenciamento de listas de jogos.
Ele permite ao usuário visualizar jogos e suas respectivas categorias.
Este projeto foi desenvolvido durante o Intensivão Java Spring do DevSuperior para praticar e reforçar conceitos de APIs RESTful com Spring Boot e manipulação de dados com PostgreSQL.

## 🔎 Funcionalidades

- **Visualização de Jogos**: Permite listar todos os jogos disponíveis.
- **Visualização de Jogos por Categoria**: Permite listar jogos por categoria específica.
- **Visualização de Categorias**: Permite listar todas as categorias de jogos disponíveis.
- **Reordenar Jogos na Lista**: Permite mudar a posição dos jogos dentro de uma lista.
- 
## 🛠️ Estrutura do Código

O projeto segue a estrutura padrão de um aplicativo Spring Boot, organizado em camadas:

- **Controllers**: Contém os controladores REST que gerenciam as requisições HTTP e retornam as respostas apropriadas.
- **DTOS**: Contém os Data Transfer Objects que são usados para transferir dados entre as camadas do sistema.
- **Entities**: Contém as entidades JPA que representam as tabelas do banco de dados.
- **Projections**: Contém as interfaces de projeção JPA que são usadas para definir consultas específicas.
- **Repositories**: Contém os repositórios JPA que gerenciam a persistência e recuperação dos dados.
- **Services**: Contém os serviços que implementam a lógica de negócio do aplicativo.


## 🌐 Rotas da API

- `GET /games`: Retorna um array de todos os jogos disponíveis.
    - Exemplo de retorno:
      ```json
      [
        {
          "id": 1,
          "title": "The Binding of Isaac: Rebirth",
          "year": 2014,
          "imgUrl": "https://raw.githubusercontent.com/Brendon3578/java-dslist/main/game-images/the-binding-of-isaac-rebirth.jpg",
          "shortDescription": "A randomly generated action RPG shooter."
        }
      ]
      ```

- `GET /lists/1/games`: Retorna um array de jogos pertencentes à lista de categorias de ID 1.
    - Exemplo de retorno:
      ```json
      [
        {
          "id": 1,
          "title": "The Binding of Isaac: Rebirth",
          "year": 2014,
          "imgUrl": "https://raw.githubusercontent.com/Brendon3578/java-dslist/main/game-images/the-binding-of-isaac-rebirth.jpg",
          "shortDescription": "A randomly generated action RPG shooter."
        }
      ]
      ```

- `GET /lists`: Retorna um array de todas as categorias de jogos disponíveis.
    - Exemplo de retorno:
      ```json
      [
        {
          "id": 1,
          "name": "Roguelike Games"
        }
      ]
      ```

- `POST /lists/{listId}/replacement`: Permite reordenar a posição dos jogos dentro de uma lista específica.
    - Payload do request:
      ```json
      {
        "sourceIndex": 0,
        "destinationIndex": 2
      }
      ```
    - Descrição: Move as posições dos jogos de uma posição `sourceIndex` para `destinationIndex` dentro da lista especificada por `listId` e re-organiza os jogos seguintes.


## 📚 Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **PostgreSQL**
- **H2 Database** (para testes locais)

## 🎉 Como utilizar

Antes de utilizar, é importante alterar o perfil utilizado pela API pelo arquivo `application.properties` localizado em *src/main/resources*.

- É possível mudar para os perfis `:dev` ou `:prod` para usar o postgresql na porta 5432 (é necessário ter criado o banco dslist) e ter executado a query do arquivo `create.sql` que está na pasta raiz do projeto.
- Ou utilizar o perfil `:test` para utilizad o banco de dados em memória H2.

```properties
# change to :dev or :prod or :test
spring.profiles.active=${APP_PROFILE:test}
```

Ao rodar o sistema, o usuário pode visualizar jogos, suas categorias e jogos por categoria através das rotas da API. Aqui está um exemplo de como usar o sistema:

1. Visualizar todos os jogos disponíveis:
    ```sh
    curl http://localhost:8080/games
    ```
2. Visualizar jogos de uma categoria específica (por exemplo, lista de ID 1):
    ```sh
    curl http://localhost:8080/lists/1/games
    ```
3. Visualizar todas as categorias de jogos:
    ```sh
    curl http://localhost:8080/lists
    ```
4. Reordenar a posição dos jogos dentro de uma lista específica (por exemplo, lista de ID 1):
   ```sh
   curl -X POST http://localhost:8080/lists/1/replacement -H "Content-Type: application/json" -d '{"sourceIndex":0,"destinationIndex":2}'
    ```

---

<h3 align="center">
    Feito com ☕ por <a href="https://github.com/Brendon3578">Brendon Gomes</a>
</h3>