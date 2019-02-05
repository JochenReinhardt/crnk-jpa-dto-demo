package io.crnk.demo.jpa.computedvalue.plain;

import io.crnk.core.resource.meta.DefaultHasMoreResourcesMetaInformation;
import io.crnk.jpa.JpaEntityRepositoryBase;
import io.crnk.jpa.JpaRepositoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlainRepository extends JpaEntityRepositoryBase<PlainDTO, Long> {
    @Autowired
    public PlainRepository(PlainJpaMapper mapper) {
        super(JpaRepositoryConfig.builder(PlainEntity.class, PlainDTO.class, mapper)
                .setListMetaClass(DefaultHasMoreResourcesMetaInformation.class)
                .build());
    }
}
