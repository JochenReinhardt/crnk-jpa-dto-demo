package io.crnk.demo.jpa.repositorydecorator.modern;

import io.crnk.core.repository.decorate.ResourceRepositoryDecoratorBase;

public class ModernRepositoryDecorator extends ResourceRepositoryDecoratorBase<ModernDTO, Long> {
    public static final String MODIFIED_BY_DECORATOR = "Modified by modern Decorator";

    @Override
    public <S extends ModernDTO> S save(S entity) {
        entity.setValue(MODIFIED_BY_DECORATOR);
        return super.save(entity);
    }
}
