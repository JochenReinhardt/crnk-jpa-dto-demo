package io.crnk.demo.jpa.manytomany.left;

import io.crnk.jpa.JpaEntityRepositoryBase;
import io.crnk.jpa.JpaRepositoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeftRepository extends JpaEntityRepositoryBase<LeftDTO, Long> {
    @Autowired
    public LeftRepository(LeftJpaMapper mapper) {
        super(JpaRepositoryConfig.builder(LeftEntity.class, LeftDTO.class, mapper)
                .build());
    }
}
