# registration-login
Registration and Login Example with Spring Boot, Spring Security, Spring Data JPA, Hibernate, HSQL, JSP and Bootstrap

Please follow the steps given below to access the UI

1. Check out the project from GitHub https://github.com/s6rapala/registration-login
2. In eclipse, File -> Import -> Import from Existing Maven Projects -> Select Maven Projects.
3. In the Root directory specify the maven project folder which you have checked out from step 1.
4. Right click on the projects and configure Run As -> Run Configuration.
5. Double click on the maven build to create a new maven configuration.
6. In it mention, goals as spring-boot:run and click the run button.
7. In the console window, servlet engine Apache Tomcat/9.0.13 is started.
8. Wait till Tomcat is initialized with ports 8080.
9. Open the browser, navigate to localhost:8080/registration for a UI.
10. Register details such username, password and confirmation password.
11. Upon entering the details, hit the endpoint /PUT or goto localhost:8080/login and enter the login details.
