package io.crnk.demo.jpa.mtonlegacy.left;

import io.crnk.jpa.JpaModuleConfig;
import io.crnk.jpa.JpaRepositoryConfig;
import io.crnk.spring.setup.boot.jpa.JpaModuleConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeftRepository implements JpaModuleConfigurer {
    private LeftJpaMapper mapper;

    @Autowired
    public LeftRepository(LeftJpaMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void configure(JpaModuleConfig jpaModuleConfig) {
        jpaModuleConfig.addRepository(
                JpaRepositoryConfig.builder(LeftEntity.class, LeftDTO.class, mapper).build());

    }
}
