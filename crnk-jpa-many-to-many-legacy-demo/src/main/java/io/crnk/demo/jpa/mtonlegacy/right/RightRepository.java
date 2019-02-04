package io.crnk.demo.jpa.mtonlegacy.right;

import io.crnk.jpa.JpaModuleConfig;
import io.crnk.jpa.JpaRepositoryConfig;
import io.crnk.spring.setup.boot.jpa.JpaModuleConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RightRepository implements JpaModuleConfigurer {

    private RightJpaMapper mapper;

    @Autowired
    public RightRepository(RightJpaMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void configure(JpaModuleConfig jpaModuleConfig) {
        jpaModuleConfig.addRepository(
                JpaRepositoryConfig.builder(RightEntity.class, RightDTO.class, mapper).build());

    }

}
