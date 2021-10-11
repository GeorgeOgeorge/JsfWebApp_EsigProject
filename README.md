# JSF_WebApp
This Java-Web data management application was implemented as a requirement to participate in a selection of internship vacancies. In it, three-tier development concepts were used in conjunction with the web implementation, which in turn uses JSF and JPA technologies.

## Programs, applications, libraries and dependencies used

### [Java-8.0](https://www.java.com/en-US/download/help/whatis_java.html)
programming language used

### [Maven](https://maven.apache.org/index.html)
Project manager that helps the developer with the control and management of:
-> *Dependencies*
-> Bilds
-> Documentation
-> etc.

### [PostgreSQL](https://www.postgresql.org/)
PostgreSQL is an object relational database manager system.

### [TomCat Apache](http://tomcat.apache.org/)
Tomcat is a Java-Web server, which implements Java Servlet and JavaServer Pages technologies, thus allowing the application to be available for connection in Browser.

### [Lombok](https://projectlombok.org/)
Library that streamlines many of the implementations that would be performed
*write less code more*

### [PrimeFaces](https://www.primefaces.org/)
PrimeFaces is an open source UI component library for JavaServer Faces based applications

### [dependencies used](https://github.com/GeorgeOgeorge/Projeto_Esig/blob/master/pom.xml)
-> hibernate-core 5.4.12.Final

-> postgresql 42.2.19

-> junit 4.13.2

-> lombok 1.18.18

-> javax.faces 2.4.0

-> primefaces 8.0

-> weld-servlet-core 3.1.4.Final

-> omnifaces 3.5

-> javax.validation validation-api 2.0.1.Final

-> hibernate-validator 6.0.13.Final

## Screens and features
The System has four screens for data manipulation, all of them available for access through a navigation bar

### Screen of registration and handling of employees

#### Registration
On this screen it is possible to register an employee so that he is responsible for a task. The user must provide the name and telephone number of an employee to register him or her in the system. The user should not be concerned with entering a registration number or identifier, as the system itself will be responsible for ensuring that two employees do not have the same identifier.

#### Registered employees report
It will be possible to check all employees registered in the system.

#### Change and Delete
If one of the employees shown in the table is selected, the user can change the data in the text boxes or delete the employee as soon as the user presses one of the buttons.

### Screen for registering a task
In this screen, the user can register a task, as well as in the employee, the control of the identification number is up to the system, as well as the status of a task, which in turn is always *In progress* when created.

### Screen for handling a task
Just like the employee table, the user can change the data and delete a task once selected, however, the user can also mark a task as *completed*.

### Task Reports Screen
On this screen, the user can use the available fields to filter specific tasks.
