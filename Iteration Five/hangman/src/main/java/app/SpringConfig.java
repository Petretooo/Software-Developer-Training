package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import app.model.Word;
import app.util.LoggerAspect;

@Configuration
public class SpringConfig {

	@Bean
	public LoggerAspect getControllerAspect() {
		return new LoggerAspect();
	}
	
	private static final Logger log = LoggerFactory.getLogger(SpringConfig.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


//	@Autowired private RankService rank;
//	@Autowired private Bus bus;
//	
//	
//	
//	@Bean
//	public Endpoint rankEndpoint() {
//		Endpoint end = new EndpointImpl(bus, rank);
//		end.publish("http://localhost:8080/testSOAP");
//		return end;
//	}

//	@Bean(name = Bus.DEFAULT_BUS_ID)
//	public SpringBus springBus() {
//		return new SpringBus();
//	}

//    @Bean
//    public Rank weatherService() {
//        return new WeatherServiceEndpoint();
//    }

//	@Autowired
//	private Bus bus;
//
//	@Bean
//	public Endpoint endpoint() {
//		EndpointImpl endpoint = new EndpointImpl(bus, new RankServiceImpl());
//		endpoint.publish("/Hello");
//		return endpoint;
//	}

}