package BE.UniBuddy_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EntityScan("BE.UniBuddy_crud.domain")

public class UniBuddyCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniBuddyCrudApplication.class, args);
	}

}
