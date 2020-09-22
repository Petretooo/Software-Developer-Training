# Full-Stack-Software-Developer-Training

#1 Servlet API
    
    -Servlet API, JSP, JSTL, Tag Files
    
    -Maven, HTTP, URI, Eclipse, Google Java Style, SonarLint

    -Few tasks with Servlet API

#2 Spring Core – IoC/DI, AOP, Proxy

    -Spring Core

    -Junit 5, AssertJ/Harmcrest, Mockito
    
    -CL Spring, AOP, 60% code coverage unit test

#3 Spring MVC

    -Spring MVC
    
    -Integration Testing, GitLab
    
    -User Management App (in memory), integration testing

#4 JPA/Hibernate
    
    -Spring Data, JPA/Hibernate, JPA Metamodel

    -Flyway (DB migrations), 3 tire architecture

    -3c + backend + DB migrations

#5 Web Services

    -SOAP/CXF + REST/Spring MVC (JAX-RS/RestEasy) Tolerant Reader pattern

    -WS testing

    -4c open 1 SOAP and few REST endpoints

#6 ReactJS

    -ES2017+, ReactJS, react-bootstrap, react-router, formik

    -NPM + Webpack, Prettier JS Standard, ESLint + React and AirBnB rules

    -5c replace front-end with ReactJS

#7 Team play

______________________________________________________________________________________________

====>

1.Iteration One

#1 Maven - https://maven.apache.org/guides/getting-started/index.html
    
    -Dependencies
    
    -Dependency Management
    
    -Plugins configuration

                 i.      frontend-maven-plugin – make Maven build to run NPM build

                 ii.      jaxws-maven-plugin – code generation from WSDL

#2 Servlet/JSP - https://docs.oracle.com/javaee/5/tutorial/doc/bnafd.html

    -Servlet, Filter, Listeners + 3 scopes/contexts

    -Annotations vs web.xml

    -WAR file structure

    -Maven file structure for WAR packaging

    -JSP, tag libs, JSTL - https://docs.oracle.com/javaee/5/tutorial/doc/bnakc.html

    -Tag Files - https://docs.oracle.com/javaee/5/tutorial/doc/bnama.html

#3 Tasks

    -Clone https://github.com/hrabur/servlet-jsp-demo, fix, upgrade to Servlet 3.1 and solve 
    the open tasks

    -Create CRUD application for user management (list users, add user, delete user, modify user):

                  i.      based on Servlet API + JSP/JSTL

                  ii.      using Tag File as layout template

                  iii.      store users in memory in the servlet context


Възможна литература:
https://github.com/hrabur/web-programming-course/wiki




=====>

2.Iteration Two

#1 Spring Core - https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#spring-core

    -Design pattern used in Spring

                  i.      Dependency Injection (DI) и Inversion of Control (IoC)

                 ii.      Proxy (Посредник)

    -Spring Been и неговият жизнен цикъл

                  i.      Наични да се превърне POJO в Spring Been (анотация, xml, Java config, etc.)

                 ii.      Жизнен цикъл на Spring application context-а (контейнера) и Spring Been-овете

    -Видове dependency injection подържани от Spring (анотациии, xml, Java config)

    -Java конфигурация и classpath scanning

    -AOP in Spring (AspectJ и Spring AOP style approach)
#2 Multi-tire architecture – 2 tire architecture (presentation Servlet API + JSP, business logic 

#3Spring Core + Spring Beans - *ApplicationContext + ServletContextListner.onStart?)
Junit 5 + Harmcrest/AssertJ + Mockito

#4 Test - Hangman
    
    -Index page – Welcome + start new game (POST /games) – redirect to Game page (/games/{gameId})
    
    -Game page – puzzled word, tries left, letters left (button) – reload game page on try (POST /
    games/{gameId}) redirect game or game over page

    -Game over page – Well done/Sorry + start new game (POST /games)
 

Words in English stored in the code as array/collection

Words is chosen random on start new game

Multiple player can play at the same time on the server separate games

GameService – startNewGame, makeTry, etc.

80% code coverage of the business logic

AnnotationConfigApplicationContext







=====>

3. Iteration Three

#1 SpringMVC (WebFlux is excluded)

    -How to integrate with Servlet Container

    -Controllers and handler methods
     
                 i.      Possible args and return types - https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-methods

                 ii.      Data binding

    -Error handing - @ControllerAdvice

    -Model/ModelMap/@ModelAttribute

    -String/ModelAndView – VewResolver how it works and how to configure - https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-view-jsp-jstl

    -@RequestBody/@ResponseBody – Used to implement REST API

    -ResourceHandlers – serve files from file system or classpath
    
    -Iterceptors (like Servlet Filters)

#2 Selenium/WebDriver

    -Upgrade your unit tests with the new implementation of GameService + use only AssertJ + Mockito 
    (if necessary)

    -Implement integration test suite to test Hangman from the browser

    -XPath + CSS Selectors (preferably)

    -Approached to avoid flaky tests

                      i.      Gray box – access to DB or some app internals + knowledge

                     ii.      Cheats – Start new game with appointed word or expose the word trough a dedicated endpoint!!!

#3 Practical task

    -Refactor current hangman (server side rendering with JSP) to what was demonstrated + following RESTfull style URLs + UI showing the left letter like buttons + Bootstrap to style better your app

    -GET / - Welcome with option to start new game

    -POST /games - start new game; redirect to the new game GET /games/23452345-sdgsdfg-twet-sdfggsdfg

    -GET /games/23452345-sdgsdfg-twet-sdfggsdfg - returns view of the current state of the game with corresponding ID; buttons with letters left to make a try

    -POST /games/23452345-sdgsdfg-twet-sdfggsdfg/tries - make a try; redirect GET /games/23452345-sdgsdfg-twet-sdfggsdfg

    -GET /games/23452345-sdgsdfg-twet-sdfggsdfg/real-word - Cheet

 

!First + last visible + all matching inside and removed from letters left

Hangman example:

https://github.com/hrabur/hangman2020

https://github.com/hrabur/hangman






=====>

4. Iteration Four

#1 Spring Boot

    -Embedded Servlet Container (Tomcat) – this iteration we continue to build WAR and deploy it in Tomcat

    -Auto-configuration – reasonable defaults + application.properties|yml

                           i.      https://docs.spring.io/spring-boot/docs/2.1.9.RELEASE/reference/html/boot-features-external-config.html

                          ii.      Profiles, how to use and configure

#2 Spring Boot initializer + starters

    -SQL

        -DDL

                          i.      Create table

                         ii.      Alter table

                         iii.      Etc.

    -DML

                          i.      Select

                            1.Inner join

                            2.Left join

                            3.Right join

                            4.Group by + having

                            5.In clause

                         ii.      Update

                         iii.      insert

#3 JPA/Hibernate

    -JPA – bean to entity mapping using annotations

    -One-to-one, one-to-many, many-to-many – How to implement, annotations, etc.

    -Inheritance – 3 strategies

#4 DAO/Repository pattern

    -Every entity has DAO

    -CrudDao – hand made (get, listAll, create, delete, update)

    -EntityManager – use to implement CRUD and other specific queries

    -Hibernate Criteria API - https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm

    -JPA type safe query API - https://www.tutorialspoint.com/jpa/jpa_criteria_api.htm + JPA Metamodel - https://www.baeldung.com/hibernate-criteria-queries-metamodel

    -HQL and JPQL – outside of the iteration scope, you can just take a look for information

#5 Spring Data

    -CRUD operation easy

    -Custom queries using conventions

    -Spring Data Specifications + JPA Criteria Query - https://www.baeldung.com/spring-data-criteria-queries#specifications

#6 (Secondary goal) DB Migrations with Flyway
 
#7 Practical Task

    1.Clean the manual configuration

    2.Add persistence layer to Hangman

        -Keep games in the DB

        -MariaDB/MySQL

        -Game/HangmanRepository to be implemented as DAO pattern with custom CrudDao (see 3b, c, d, e)

    3.Add game statistic keeping data for every completed game (separate table) – one to one relation to game

    4.Make Ranking per gamer in separate table with one-to-many relation to statistics

    5.When game ends update stats + ranking – RankingService
    
        -Stats and Rank entities use Spring Data
    
    6.Rank page as home page and when game is over (top 10 players)

        -Top 10 ever Spring Data + conventions (4 a + b)

        -Top 10 for last 30 days use Spring Data specifications (4c)

    7.Flayway migrations to initialize DB schema + some mockup data for statistics and ranking - https://flywaydb.org/getstarted/how
 






 =====>

 5. Iteration Five

 #1 Web services:
 
    -Main task
 
        1.SOAP (one week)
 
                         i.      Read a bit about SOAP (WSDL)

                         ii.      XML (well formed vs valid), XML schema, WSDL

                         iii.      JAXB – quick check the annotations supported (marshal/unmarshal)

                          iv.      JAX-WS / Apache CXF

                                -Annotations to describe the SOAP WS

                                -Code first

                                -WSDL (contract) first
                        
        2.REST
                         i.      Read about REST concept

                         ii.      https://github.com/paypal/api-standards/blob/master/api-style-guide.md

                         iii.      JSON / Jackson

                          iv.      JSON-B (just for info, out of the scope)

                           v.      JAX-RS / Jersey (just for info, out of the scope)

                          vi.      Spring MVC

                                1.@RestController
                                2.How to use SpringMVC to realize REST APIs
                                3.MessageConverter instead of ViewResolvers
                         vii.      RestTemplate

#2 Testing web services (integration tests)
    
    -Junit
    
    -Generate consumer of SOAP API to test it (WSDL (contract) first)

    -RestTemplate (spring-web)

    -RestAssuared
    
#3 Practical task

    -Open one SOAP web service to get the scores/ranking and generate WSDL

    -SoapUI for manual testing of SOAP web services

    -Expose hangman as REST API
                      i.      GET \api\games -> list active games

                     ii.      POST \api\games -> start new game

                     iii.      GET \api\games\{gameID} -> get info about the game

                      iv.      POST \api\games\{gameID}\tries

    -Write tests that consume the aforementioned WS and prove they work correctly

    -Spring Boot tests – mockup container integration tests

    
$Additional information to the Iteration Five

    1.Upgrade to Spring Boot

        - Use Spring Boot and CXF integration to build SOAP endpoint
    
        -Hint: http://cxf.apache.org/docs/springboot.html#SpringBoot-SpringBootCXFJAX-WSStarter
    
    2.You can take a look on CXF auto-configuration to see how CXF is configured to work with Spring
    Write integration test with build from WSDL client consuming/testing the exposed endpoint
        
        -Hint: Use https://www.mojohaus.org/jaxws-maven-plugin/ to generate the client code form WSDL and CXF as implementation
    
    3.Take a look on the WSDL and XSD
    
    4.Read in depth about REST principles, maturity model (HATEOAS), PayPal guidelines https://github.com/paypal/api-standards/blob/master/api-style-guide.md
    
    5.Expose REST APIs using Spring MVC following the above guidelines and eventually using HATEOAS
    
    6.Write integration tests to consume/validate the exposed REST endpoints
    
    7.Integrate Swagger using Springfox to auto-generate documentation and playground for the REST APIs