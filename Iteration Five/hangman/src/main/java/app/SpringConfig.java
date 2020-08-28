package app;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.service.rank.RankService;
import app.service.rank.RankServiceImpl;
import app.util.LoggerAspect;

@Configuration
public class SpringConfig {

	@Bean
	public LoggerAspect getControllerAspect() {
		return new LoggerAspect();
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