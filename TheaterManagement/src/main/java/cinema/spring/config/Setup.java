package cinema.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cinema.spring.dao.DirectorDAO;
import cinema.spring.dao.DirectorDAOImpl;
import cinema.spring.dao.LoginDAO;
import cinema.spring.dao.LoginDAOImpl;
import cinema.spring.dao.MovieDAO;
import cinema.spring.dao.MovieDAOImpl;
import cinema.spring.dao.ActorDAO;
import cinema.spring.dao.ActorDAOImpl;
import cinema.spring.dao.SearchDAO;
import cinema.spring.dao.SearchDAOImpl;
import cinema.spring.dao.ShowingDAO;
import cinema.spring.dao.ShowingDAOImpl;
import cinema.spring.dao.UserPaymentDAO;
import cinema.spring.dao.UserPaymentImpl;
import cinema.spring.dao.WriterDAO;
import cinema.spring.dao.WriterDAOImpl;


@Configuration
@ComponentScan(basePackages="cinema.spring")
@EnableWebMvc
public class Setup extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@***");		
		dataSource.setUsername("***");		
		dataSource.setPassword("***");
		
		return dataSource;
	}
	
	@Bean
	public MovieDAO getMovieDAO() {
		return new MovieDAOImpl(getDataSource());
	}
	
	@Bean
	public SearchDAO getSearchDAO() {
		return new SearchDAOImpl(getDataSource());
	}
	@Bean
	public ShowingDAO getShowingDAO() {
		return new ShowingDAOImpl(getDataSource());
	}
	
	@Bean
	public ActorDAO getActorDAO() {
		return new ActorDAOImpl(getDataSource());
	}
	
	@Bean
	public DirectorDAO getDirectorDAO() {
		return new DirectorDAOImpl(getDataSource());
	}
	
	@Bean
	public WriterDAO getWriterDAO() {
		return new WriterDAOImpl(getDataSource());
	}
	
	@Bean
	public UserPaymentDAO getUserPaymentDAO() {
		return new UserPaymentImpl(getDataSource());
	}
	
	@Bean
	public LoginDAO getLoginDAO() {
		return new LoginDAOImpl(getDataSource());
	}	
	
}
