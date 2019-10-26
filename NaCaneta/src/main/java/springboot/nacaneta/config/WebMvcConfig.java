package springboot.nacaneta.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages = { "org.websparrow.controller", "org.websparrow.dao" })
public class WebMvcConfig {

	
	private static final String ACCESS_KEY = "admin";
	private static final String SECRET_KEY = "admin123";
	
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");

		return vr;
	}
	
	@Bean
	public static DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://db-ee.cyqhp78drxs4.sa-east-1.rds.amazonaws.com:3306/cotacaosystem");
		ds.setUsername(ACCESS_KEY);
		ds.setPassword(SECRET_KEY);

		return ds;
	}
	
	
	
}