package ie.gti.recordsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//@Configuration
//@EnableTransactionManagement
//@ComponentScan("ie.gti.recordsystem")
//@PropertySource("classpath:database.properties")
//public class ApplicationConfig {

//    @Autowired
//    Environment environment;
//
//    @Value("${url}")
//    private String dbUrl;
//
//    @Value("${dbuser}")
//    private String dbUser;
//
//
//    @Value("${dbpassword}")
//    private String dbPassword;
//
//    @Value("${driver}")
//    private String dbDriver;
//
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setUrl(dbUrl);
//        driverManagerDataSource.setUsername(dbUser);
//        driverManagerDataSource.setPassword(dbPassword);
//        driverManagerDataSource.setDriverClassName(dbDriver);
//        return driverManagerDataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

//}
