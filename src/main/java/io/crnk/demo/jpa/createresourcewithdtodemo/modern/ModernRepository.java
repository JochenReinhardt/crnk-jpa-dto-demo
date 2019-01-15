package io.crnk.demo.jpa.createresourcewithdtodemo.modern;

import io.crnk.jpa.JpaEntityRepositoryBase;
import io.crnk.jpa.JpaRepositoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModernRepository extends JpaEntityRepositoryBase<ModernDTO, Long> {
    @Autowired
    public ModernRepository(ModernJpaMapper mapper) {
        super(JpaRepositoryConfig.builder(ModernEntity.class, ModernDTO.class, mapper).build());
    }
}
