package app.service.word;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

  private static final String[] WORDS =
      {"JAVA", "SPRING", "HIBERNATE", "SWING", "MAVEN", "GRADLE", "PLAY", "QUARKUS", "STRUTS",
          "SPARK", "SONAR", "JUNIT", "TOMCAT", "ECLIPSE", "ANDROID", "SERVLET", "JSP", "GRAILS",
          "JENKINS", "DOCKER", "GWT", "JSF", "VAADIN", "BLADE", "VERTX", "WICKET", "MICRONAUT", "HTML", "CSS",
          "JAVASCRIPT", "SQL", "PYTHON", "CSHARP", "PHP", "TYPESCRIPT", "RUBY", "GO", "ASSEMBLY", "SWIFT", "KOTLIN","OBJECTIVEC","ELIXIR",
          "DART", "CLOJURE", "JQUERY","REACT", "ANGULAR", "ASP", "EXPRESS", "VUE", "DJANGO", "FLASH", "LARAVEL", "DRUPAL", "TENSORFLOW",
          "CORDOVA", "XAMARIN", "HADOOP", "JPA", "PYTORCH", "MYSQL", "POSTGRESQL", "MONGODB","MARIADB", "CASSANDRA", "FIREBASE",
          "LINUX", "WINDOWS", "AWS", "ANDROID", "AWS", "MACOS", "IOS", "ARDUINO", "HEROKU", "KUBERNATES", "SCALA", "ERLANG",
          "REDIS", "INTELLIJ", "VISUALSTUDIO", "BSD"};

  @Override
  public String randomWordGenerator() {
    Random random = new Random();
    return WORDS[random.nextInt(WORDS.length)];
  }

}
