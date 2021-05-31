package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"Reservation.dao","Reservation.dto"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
