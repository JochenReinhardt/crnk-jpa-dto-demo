package io.crnk.demo.jpa.manytomany.right;

import io.crnk.jpa.JpaEntityRepositoryBase;
import io.crnk.jpa.JpaRepositoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RightRepository extends JpaEntityRepositoryBase<RightDTO, Long> {
    @Autowired
    public RightRepository(RightJpaMapper mapper) {
        super(JpaRepositoryConfig.builder(RightEntity.class, RightDTO.class, mapper)
                .build());
    }
}
