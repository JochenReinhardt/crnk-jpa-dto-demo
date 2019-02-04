package io.crnk.demo.jpa.mtonlegacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ManyToManyLegacyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyLegacyDemoApplication.class, args);
	}

}

