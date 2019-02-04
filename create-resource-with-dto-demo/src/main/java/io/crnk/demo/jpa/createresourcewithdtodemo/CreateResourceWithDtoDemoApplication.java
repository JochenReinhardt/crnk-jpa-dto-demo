package io.crnk.demo.jpa.createresourcewithdtodemo;

import io.crnk.demo.jpa.createresourcewithdtodemo.traditional.TraditionalDTO;
import io.crnk.demo.jpa.createresourcewithdtodemo.traditional.TraditionalEntity;
import io.crnk.demo.jpa.createresourcewithdtodemo.traditional.TraditionalJpaMapper;
import io.crnk.jpa.JpaRepositoryConfig;
import io.crnk.spring.setup.boot.jpa.JpaModuleConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class CreateResourceWithDtoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateResourceWithDtoDemoApplication.class, args);
	}

	@Bean
	public JpaModuleConfigurer jpaModuleConfigurer(TraditionalJpaMapper mapper) {
		return config -> config.addRepository(JpaRepositoryConfig.builder(TraditionalEntity.class, TraditionalDTO.class, mapper).build());
	}

}

