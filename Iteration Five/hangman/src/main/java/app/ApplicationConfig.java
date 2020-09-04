package app;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.service.rank.RankService;
import app.service.rank.RankServiceImpl;

@Configuration
public class ApplicationConfig {
	
	
	@Autowired private Bus bus;
	
	@Autowired private RankService rank;
	
	@Bean
	public Endpoint rankServiceEndpoint() {
		Endpoint endpoint = new EndpointImpl(bus, rank);
		endpoint.publish("http://localhost:8081/RankService");
		return endpoint;
	}
	

}