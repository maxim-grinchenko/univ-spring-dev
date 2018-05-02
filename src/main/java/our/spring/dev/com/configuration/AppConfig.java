package our.spring.dev.com.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author vasya
 */
@Configuration
@EnableWebMvc
@ComponentScan("our.courses.brovary.com.*")
@PropertySource(value = {"classpath:application.properties", "classpath:db.properties"})
public class AppConfig {
}