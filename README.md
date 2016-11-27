# ejb-sandbox

## Sandbox project to play around with EJB

### Installation
1. Create a mysql database: `create database livraria`;
2. On your application server, create a JTA datasource pointing do the database; (check \src\main\resources\META-INF\persistence.xml)
3. Generate the war `mvn install` and deploy it at your application server.

### Usage
Access URL: http://localhost:8080/ejb-sandbox/login.xhtml
