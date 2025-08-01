# Store Application - Spring Boot Project

## 📝 Visão Geral

Este é um projeto Spring Boot que demonstra o uso de JPA/Hibernate para mapeamento objeto-relacional com integração a uma base de dados MySQL. O projeto inclui:

- Migrações de base de dados com Flyway
- Uso de Lombok para reduzir código repetitivo
- Relacionamentos complexos entre entidades (1:1, 1:N, N:M)
- Organização modular e limpa de um sistema de loja online (Store)

---

## 🚀 Funcionalidades

- Sistema de gestão de utilizadores com perfis detalhados
- Gestão de moradas associadas a utilizadores
- Sistema de tags com relacionamento Many-to-Many
- Catálogo de produtos organizados por categorias
- Migrações de versão de base de dados com Flyway

---

## ⚙️ Tecnologias Utilizadas

- **Spring Boot** 3.x – Framework principal para construção da aplicação
- **JPA/Hibernate** – ORM para persistência de dados
- **MySQL** – Sistema de gestão de base de dados relacional
- **Flyway** – Ferramenta de controlo de versão da base de dados
- **Lombok** – Anotações para gerar código boilerplate (getters, setters, etc.)
- **Maven** – Sistema de gestão de dependências e build

---

## 🧩 Relacionamentos Entre Entidades

### 👤 User
- `@OneToOne` com **Profile**
- `@OneToMany` com **Address**
- `@ManyToMany` com **Tag**

### 🧾 Profile
- `@OneToOne` com **User** (chave primária partilhada)

### 📍 Address
- `@ManyToOne` com **User**

### 🏷️ Tag
- `@ManyToMany` com **User**

### 🗂️ Category
- `@OneToMany` com **Product**

### 📦 Product
- `@ManyToOne` com **Category**

---

## 🛢️ Esquema da Base de Dados

Gerido através de ficheiros Flyway localizados em:  
`src/main/resources/db/migration`

**Tabelas principais:**
- `users`: Armazena dados básicos dos utilizadores
- `profiles`: Detalhes adicionais dos utilizadores
- `addresses`: Moradas dos utilizadores
- `tags`: Lista de tags disponíveis
- `user_tags`: Tabela de junção (users ↔ tags)
- `categories`: Categorias dos produtos
- `products`: Detalhes dos produtos

---

## ▶️ Primeiros Passos

### ✅ Pré-requisitos

- Java 17 ou superior  
- MySQL 8 ou superior  
- Maven instalado  

### 📦 Instalação

1. **Clonar o repositório:**

```bash
git clone https://github.com/yourusername/store-application.git
cd store-application
```

2. **Configurar a ligação à base de dados no `application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
```

3. **Executar a aplicação:**

```bash
mvn spring-boot:run
```

---

## 🧪 Exemplos de Uso

Criação de entidades e associação entre elas:

```java
// Criar utilizador com perfil e morada
var user = User.builder()
    .name("Joao")
    .password("pass")
    .email("joao@example.com")
    .build();

var profile = Profile.builder()
    .bio("bio1")
    .build();

var address = Address.builder()
    .city("Porto")
    .state("Porto")
    .zip("4700")
    .street("Rua")
    .build();

user.setProfile(profile);
profile.setUser(user);

user.addAddress(address);
user.addTag("tag1");

// Criar categoria com produto
var category = Category.builder()
    .name("Java")
    .build();

var product = Product.builder()
    .name("Frango")
    .price("10.99")
    .build();

category.getProducts().add(product);
product.setCategory(category);
```

---

## 📂 Estrutura do Projeto

```
src/main/java/com/joaoalves/storeapplication/
├── entities/
│   ├── Address.java
│   ├── Category.java
│   ├── Product.java
│   ├── Profile.java
│   ├── Tag.java
│   └── User.java
├── StoreApplication.java

src/main/resources/
├── application.properties
└── db/migration/
    ├── V1__Create_users_table.sql
    ├── V2__Create_addresses_table.sql
    ├── V3__Add_state_to_addresses.sql
    ├── V4__Create_profiles_table.sql
    ├── V5__Create_tags_system.sql
    └── V6__Create_product_catalog.sql
```

---

## 🧬 Migrações com Flyway

As migrações gerem automaticamente a criação e atualização do schema da base de dados.

### Exemplos incluídos:
- Criação da tabela `users`
- Adição da tabela `addresses` com foreign key
- Criação de `profiles` com relação 1:1
- Criação do sistema de tags (users ↔ tags)
- Criação de categorias e produtos

---

## 📄 Licença

Este projeto está disponível como open-source sob a licença **MIT**.

---

## ✍️ Autor

**João Alves**  
[LinkedIn](https://www.linkedin.com/in/seu-perfil) • [GitHub](https://github.com/yourusername)
