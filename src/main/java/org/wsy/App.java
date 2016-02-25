package org.wsy;

import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.WebApplicationInitializer;



//@SpringBootApplication
////@ImportResource("classpath*:spring-config.xml")
//public class App implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext arg0) throws ServletException {
//		SpringApplication.run(SpringWsWarApplication.class);
//	}
//
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//		factory.setPort(8080);
//		factory.setSessionTimeout(30, TimeUnit.MINUTES);
//		return factory;
//	}
//	
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix="datasource.datasource1")
//	public DataSource firstDataSource() {
//	    return DataSourceBuilder.create().build();
//	}
//	
//	@Bean
//	@ConfigurationProperties(prefix="datasource.datasource2")
//	public DataSource secDataSource() {
//	    return DataSourceBuilder.create().build();
//	}
//	
//
//}
