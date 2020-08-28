package app;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import app.service.rank.RankService;
import app.service.rank.RankServiceImpl;

@SpringBootApplication
@EnableScheduling
public class HangmanApp extends SpringBootServletInitializer {// fix name
	
	
	public static void main(String[] args) {

		SpringApplication.run(HangmanApp.class, args);
	}
	
	
}