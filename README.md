# goldenrealesatateApp
 This is the backend for GoldenRealEstate App.
 
 It is built on 
 
 Java - JDK 8
 
 Hibernate with JPA -
 
 Maven- 3.6.3 
 
 Spring Boot-2.2.1.RELEASE
 
 PostgreSQL
 
 Front end and back end will communicate via axios for http response/request .
 
 
 I have referred the details from  site:https://bezkoder.com/ and my recent project in Emirates -Future CSR .
 
 Exposed Web services are tested and verified using Postman https://www.postman.com/downloads/
 
 
 Listed are the available APIs in this release 
 
 1.http://localhost:8080/api/progressbar--> list the progress bar details 
 
 2.http://localhost:8080/api/defects - list the defect details 
 
 3.http://localhost:8080/api/buildings -list the building details 
 
 4.http://localhost:8080/api/employees - list the employee details 


Features 

1. It follows MVC architecture 

2. It has controller, model and repositories 

3. I have incorporated Junit test cases so that it can be tested and verified 

4. All the configuration details are mentioned in application.properties 

5.its a simple and easy to maintain application 


Issues faced 
1. First time using PostgreSQL --> so took sometime to familiarise with same 

2. Used spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5Dialect initially and later faced issued in connecting 
so changed to spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL8Dialect


How to run 

Since this is spring boot first build the application 

1. mvn clean install -o -DskipTests=true --> i have omitted the junit test cases here 

2. mvn spring-boot:run --> to run the application and you will see below code which confirms that your application is up and running 

2020-06-21 15:56:00.791  INFO 17688 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.4.8.Final}
2020-06-21 15:56:00.861  INFO 17688 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2020-06-21 15:56:00.925  INFO 17688 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-06-21 15:56:01.233  INFO 17688 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-06-21 15:56:01.242  INFO 17688 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
2020-06-21 15:56:01.761  INFO 17688 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2020-06-21 15:56:01.768  INFO 17688 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2020-06-21 15:56:01.970  WARN 17688 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2020-06-21 15:56:02.049  INFO 17688 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-21 15:56:02.169  INFO 17688 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-06-21 15:56:02.171  INFO 17688 --- [           main] c.g.app.SpringBootDataJpaApplication     : Started SpringBootDataJpaApplication in 5.287 seconds (JVM running for 5.628)


3.  Happy coding !!







