package CaseStudy.UserSignup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserSignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSignupApplication.class, args);
	}

}
