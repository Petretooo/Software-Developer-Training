package app;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import app.service.rank.RankServiceImpl;

@Configuration
public class ApplicationConfig {
//	@Bean
//	public ServletRegistrationBean<CXFServlet> dispatcherServlet() {
//		return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/soap-api/*");
//	}
//  @Bean
//  @Primary
//  public DispatcherServletPath dispatcherServletPathProvider() {
//      return () -> "";
//  }
//  @Bean(name=Bus.DEFAULT_BUS_ID)
//  public SpringBus springBus(LoggingFeature loggingFeature) {
//    SpringBus cxfBus = new  SpringBus();
//    cxfBus.getFeatures().add(loggingFeature);
//    return cxfBus;
//  }
//  @Bean
//  public LoggingFeature loggingFeature() {
//    LoggingFeature loggingFeature = new LoggingFeature();
//    loggingFeature.setPrettyLogging(true);
//    return loggingFeature;
//  }
//  
//  @Bean
//  public Endpoint endpoint(Bus bus, RankServiceImpl rank) {
//    EndpointImpl endpoint = new EndpointImpl(bus, rank);
//    endpoint.publish("/soap/rank");
//    return endpoint;
//  }

//	@Autowired
//	private ApplicationContext applicationContext;
//
//	@Bean
//	public Endpoint jaxwsEndpoint(RankServiceImpl rank) {
//		Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
//		EndpointImpl endpoint = new EndpointImpl(bus, rank);
//		endpoint.publish("/soap");
//		// also showing how to add interceptors
//		endpoint.getServer().getEndpoint().getInInterceptors().add(new LoggingInInterceptor());
//		endpoint.getServer().getEndpoint().getOutInterceptors().add(new LoggingOutInterceptor());
//
//		return endpoint;
//	}
}