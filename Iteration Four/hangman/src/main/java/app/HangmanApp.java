package app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class HangmanApp extends SpringBootServletInitializer {//fix name

  public static void main(String[] args) {  
	  
	SpringApplication.run(HangmanApp.class, args);
  }
}