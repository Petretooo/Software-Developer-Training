package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import app.util.LoggerAspect;


@Configuration
public class SpringConfig implements WebMvcConfigurer {

  @Bean
  public LoggerAspect getControllerAspect() {
    return new LoggerAspect();
  }
  
}