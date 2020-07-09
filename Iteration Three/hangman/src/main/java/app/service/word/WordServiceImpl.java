package app.service.word;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

  private static final String[] WORDS =
      {"JAVA", "SPRING", "HIBERNATE", "SWING", "MAVEN", "GRADLE", "PLAY", "QUARKUS", "STRUTS",
          "SPARK", "SONAR", "JUNIT", "TOMCAT", "ECLIPSE", "ANDROID", "SERVLET", "JSP", "GRAILS",
          "JENKINS", "DOCKER", "GWT", "JSF", "VAADIN", "BLADE", "VERTX", "WICKET", "MICRONAUT"};

  @Override
  public String randomWordGenerator() {
    Random random = new Random();
    return WORDS[random.nextInt(WORDS.length)];
  }

}
