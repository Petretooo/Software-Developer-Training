package app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class MainWebAppInitializer extends SpringBootServletInitializer {

  public static void main(String[] args) {
	  
//	  Date date = new Date();
//	  System.out.println(date);
//	  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	  
//	  StopWatch timer = new StopWatch();
//	  timer.start();
//	  Thread.sleep(60000);;
//	  timer.stop();
//	  System.out.println(timer.getTime() * 0.001);
//	  
	  
	SpringApplication.run(MainWebAppInitializer.class, args);
  }
}