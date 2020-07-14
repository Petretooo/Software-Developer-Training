# Software-Developer-Training

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