package nacaneta.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import nacaneta.dao.ListaMaterialDao;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.websparrow.controller", "org.websparrow.dao" })
public class WebMvcConfig {

	
	private static final String ACCESS_KEY = "aplicacao";
	private static final String SECRET_KEY = "aplicacao";
	
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");

		return vr;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/cotacaosystem");
		ds.setUsername(ACCESS_KEY);
		ds.setPassword(SECRET_KEY);

		return ds;
	}
	
	
}