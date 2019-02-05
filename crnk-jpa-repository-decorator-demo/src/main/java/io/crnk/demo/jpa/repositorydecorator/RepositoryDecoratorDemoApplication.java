package io.crnk.demo.jpa.repositorydecorator;

import io.crnk.demo.jpa.repositorydecorator.traditional.TraditionalDTO;
import io.crnk.demo.jpa.repositorydecorator.traditional.TraditionalEntity;
import io.crnk.demo.jpa.repositorydecorator.traditional.TraditionalJpaMapper;
import io.crnk.demo.jpa.repositorydecorator.traditional.TraditionalRepositoryDecorator;
import io.crnk.jpa.JpaRepositoryConfig;
import io.crnk.spring.setup.boot.jpa.JpaModuleConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class RepositoryDecoratorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoryDecoratorDemoApplication.class, args);
    }

    @Bean
    public JpaModuleConfigurer jpaModuleConfigurer(TraditionalJpaMapper mapper) {
        return config -> {
            config.setTotalResourceCountUsed(false);
            config.addRepository(
                    JpaRepositoryConfig.builder(TraditionalEntity.class, TraditionalDTO.class, mapper)
                            .setRepositoryDecorator(new TraditionalRepositoryDecorator())
                            .build());
        };
    }

}

