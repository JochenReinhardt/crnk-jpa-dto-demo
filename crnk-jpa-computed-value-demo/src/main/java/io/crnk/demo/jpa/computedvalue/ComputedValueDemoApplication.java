package io.crnk.demo.jpa.computedvalue;

import io.crnk.demo.jpa.computedvalue.computed.ComputedEntity;
import io.crnk.jpa.JpaModuleConfig;
import io.crnk.jpa.query.criteria.JpaCriteriaExpressionFactory;
import io.crnk.jpa.query.criteria.JpaCriteriaQueryFactory;
import io.crnk.spring.setup.boot.jpa.JpaModuleConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;

@SpringBootApplication
@Configuration
public class ComputedValueDemoApplication {
    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(ComputedValueDemoApplication.class, args);
    }

    @Bean
    public JpaModuleConfigurer jpaModuleConfigurer() {
        return jpaModuleConfig -> {
            JpaCriteriaQueryFactory queryFactory = (JpaCriteriaQueryFactory) jpaModuleConfig.getQueryFactory();
            queryFactory.registerComputedAttribute(ComputedEntity.class, "computedValue", String.class, (JpaCriteriaExpressionFactory<From<?, ComputedEntity>>) (parent, query) -> {
                CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
                return criteriaBuilder.upper(parent.get("value"));
            });
        };
    }

}

