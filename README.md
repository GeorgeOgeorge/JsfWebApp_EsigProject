# 📑Gerenciamento de Projetos - WebApp 📊
Este aplicativo de gerenciamento de projetos foi implementado como um requisito para participar de uma seleção de vagas de estágio. Foram utilizados conceitos de desenvolvimento de três camadas em conjunto com a implementação de Java-web, que por sua vez usa tecnologias JSF, Primefaces, Hibernate, etc.

## 📦 Pacotes, bibliotecas e dependências usadas 📚

### [Java 17](https://www.java.com/en-US/download/help/whatis_java.html)
Linguagem de programação orientada a objetos utilizada no projeto.

### [Java Server Faces](https://www.oracle.com/java/technologies/javaserverfaces.html)
Especificação Java para a construção de interfaces de usuário baseadas em componentes para aplicações web. 

### [Hibernate](https://hibernate.org/)
Framework para o mapeamento objeto-relacional.

### [PrimeFaces](https://www.primefaces.org/)
PrimeFaces é uma biblioteca de componentes de IU de código aberto para aplicativos baseados em JavaServer Faces.

### [Maven](https://maven.apache.org/index.html)
Gerente de projeto que ajuda o desenvolvedor com o controle e gerenciamento de: dependências, builds, documentação.

### [PostgreSQL](https://www.postgresql.org/)
PostgreSQL é um sistema gerenciador de banco de dados relacional de objetos.

### [TomCat Apache](http://tomcat.apache.org/)
O Tomcat é um servidor Java-Web, que implementa as tecnologias Java Servlet e JavaServer Pages, permitindo assim que a aplicação fique disponível para conexão no Browser.

### *Dependências utilizadas* 
[Arquivo contendo as dependências](https://github.com/GeorgeOgeorge/JsfWebApp_EsigProject/blob/master/pom.xml)
* [hibernate-core 5.4.12.Final](https://mvnrepository.com/artifact/org.hibernate/hibernate-core/5.4.12.Final)
* [postgresql 42.2.19](https://mvnrepository.com/artifact/org.postgresql/postgresql/42.2.19)
* [junit 4.13.2](https://mvnrepository.com/artifact/junit/junit/4.13.2)
* [lombok 1.18.18](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.18)
* [javax.faces 2.4.0](https://mvnrepository.com/artifact/org.glassfish/javax.faces/2.4.0)
* [primefaces 10.0.0](https://mvnrepository.com/artifact/org.primefaces/primefaces/10.0.0)
* [weld-servlet-core 3.1.4.Final](https://mvnrepository.com/artifact/org.jboss.weld.servlet/weld-servlet-core/3.1.4.Final)
* [omnifaces 3.5](https://mvnrepository.com/artifact/org.omnifaces/omnifaces/3.5)
* [javax.validation validation-api 2.0.1.Final](https://mvnrepository.com/artifact/javax.validation/validation-api/2.0.1.Final)
* [hibernate-validator 6.0.13.Final](https://mvnrepository.com/artifact/org.hibernate/hibernate-validator/6.0.13.Final)
* [primeflex 3.1.0](https://mvnrepository.com/artifact/org.primefaces.extensions/primefaces-extensions/3.1.0)

## 🗃 Estrutura do Banco de Dados 🗄
Foi solicitado a criação um sistema de controle de tarefas, para isso desenvolvi a seguinte relação de tabelas a partir do framework JPA. Na atual implementação do projeto, foram desenvolvidas as tabelas: *Projeto, Tarefa, Funcionário e Ocupação*.

![Diagrama do projeto](https://github.com/GeorgeOgeorge/images/blob/main/projectMenagerDBdiagram.png)

## ▶ Telas e recursos 👩‍💻
O Sistema possui quatro telas para manipulação de dados, todas disponíveis para acesso por meio de uma barra de navegação.

![Menu tab Gif](https://github.com/GeorgeOgeorge/images/blob/main/projectMenagerMenuTab.gif)

### 🔍 Busca por campo especifico
Todas as telas possuem campos para que os dados das tabelas sejam exibidos e filtrados.

![Menu tab Gif](https://github.com/GeorgeOgeorge/images/blob/main/projectManagerSearch.gif)

### ✔ Cadastro
O usuário irá informar os campos necessários e caso erre um valor ou esqueça algum dado obrigatório, os sistemas de validação do projeto irão informar que algo não esta certo.

![Menu tab Gif](https://github.com/GeorgeOgeorge/images/blob/main/projectManagerAdd.gif)

### ❌ Remover um registro 
Existem três maneiras de marcar um registro como inativo: remover um único registro, remover um grupo de registros e remover todos os registros. Assim que um registro é marcado como inativo, ele deixa de ser listado nas telas, porem continua existindo no banco de dados(*soft delete*).

![Menu tab Gif](https://github.com/GeorgeOgeorge/images/blob/main/projectManagerRemove.gif)

### 📝 Alterar um registro
Se um dos registros exibidos na tabela for selecionado, o usuário poderá alterar seus dados.

![Menu tab Gif](https://github.com/GeorgeOgeorge/images/blob/main/projectManagerEdit.gif)
