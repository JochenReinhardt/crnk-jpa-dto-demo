package io.crnk.demo.jpa.manytomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ManyToManyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyDemoApplication.class, args);
	}

}

