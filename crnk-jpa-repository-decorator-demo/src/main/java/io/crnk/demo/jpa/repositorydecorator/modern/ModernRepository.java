package io.crnk.demo.jpa.repositorydecorator.modern;

import io.crnk.core.resource.meta.DefaultHasMoreResourcesMetaInformation;
import io.crnk.jpa.JpaEntityRepositoryBase;
import io.crnk.jpa.JpaRepositoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModernRepository extends JpaEntityRepositoryBase<ModernDTO, Long> {
    @Autowired
    public ModernRepository(ModernJpaMapper mapper) {
        super(JpaRepositoryConfig.builder(ModernEntity.class, ModernDTO.class, mapper)
                .setRepositoryDecorator(new ModernRepositoryDecorator())
                .setListMetaClass(DefaultHasMoreResourcesMetaInformation.class)
                .build());
    }
}
