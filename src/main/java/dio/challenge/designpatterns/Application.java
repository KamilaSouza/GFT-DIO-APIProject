package dio.challenge.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
Spring Boot Project build by Spring Initializr. Dependencies:
- Spring Web
- Spring Data JPA
- H2 Database
- OpenFeign
 */

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
