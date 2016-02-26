package org.wsy;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
//@ImportResource("classpath*:spring-config.xml")//载入外部配置
public class SpringWsWarApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWsWarApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(8080);
		factory.setSessionTimeout(30, TimeUnit.MINUTES);
		return factory;
	}

	@Bean(name = "datasource1")
	@Qualifier("datasource1")
	@Primary
	@ConfigurationProperties(prefix = "datasource.datasource1")
	public DataSource firstDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "datasource2")
	@Qualifier("datasource2")
	@ConfigurationProperties(prefix = "datasource.datasource2")
	public DataSource secDataSource() {
		return DataSourceBuilder.create().build();
	}
}
