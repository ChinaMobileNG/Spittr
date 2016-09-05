package spittr.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configure other components rather than web components
 * @author i330344
 *
 */
@Configuration
@ImportResource("classpath:beans.xml")
@ComponentScan(basePackages={"spittr","spitter"},
				excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {
	//@Value("#{properties['jdbcDriver']}")
	@Value("#{dbconfig.jdbcDriver}")
	private String dbDriver;
	@Value("#{dbconfig.jdbcUrl}")
	private String dbUrl;
	@Value("#{dbconfig.username}")
	private String username;
	@Value("#{dbconfig.password}")
	private String password;
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	

	@Bean
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
		return new NamedParameterJdbcTemplate(dataSource);
	}

}
