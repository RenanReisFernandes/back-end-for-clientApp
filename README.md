# ClientApp - API para Gerenciamento de Clientes

Bem-vindo ao **ClientApp**, uma aplicação backend desenvolvida em Java com Spring Boot para gerenciar informações de clientes. Este projeto foi criado com o objetivo de fornecer uma API RESTful para operações CRUD (Create, Read, Update, Delete) de clientes.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot 3.4.4**: Framework para desenvolvimento rápido de aplicações Java.
  - **Spring Data JPA**: Para integração com banco de dados.
  - **Spring Web**: Para criação de APIs RESTful.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Lombok**: Para reduzir o boilerplate de código.
- **Flyway**: Para controle de versão do banco de dados (desativado por padrão).

---

## 🚀 Funcionalidades

- **Cadastro de Clientes**: Adicione novos clientes ao sistema.
- **Listagem de Clientes**: Consulte todos os clientes cadastrados.
- **Busca por ID**: Encontre um cliente específico pelo seu identificador.
- **Atualização de Dados**: Atualize informações de um cliente existente.
- **Exclusão de Clientes**: Remova clientes do sistema.

---

## 📂 Estrutura do Projeto

```plaintext
clientesApp/
├── src/
│   ├── main/
│   │   ├── java/com/renan/clientApp/
│   │   │   ├── controllers/       # Controladores REST
│   │   │   ├── entities/          # Entidades JPA
│   │   │   ├── services/          # Regras de negócio
│   │   │   ├── Request/           # DTOs de entrada
│   │   │   ├── Response/          # DTOs de saída
│   │   │   └──  # Classe principal
│   │   └── resources/
│   │       └──  # Configurações da aplicação
├──                         # Gerenciamento de dependências Maven
└── README.md                      # Documentação do projeto
