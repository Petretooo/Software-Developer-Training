package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.util.LoggerAspect;

@Configuration
public class SpringConfig {

	@Bean
	public LoggerAspect getControllerAspect() {
		return new LoggerAspect();
	}

}