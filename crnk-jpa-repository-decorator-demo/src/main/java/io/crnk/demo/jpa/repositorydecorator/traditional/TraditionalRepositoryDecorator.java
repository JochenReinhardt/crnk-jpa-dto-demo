package io.crnk.demo.jpa.repositorydecorator.traditional;

import io.crnk.core.repository.decorate.ResourceRepositoryDecoratorBase;

public class TraditionalRepositoryDecorator extends ResourceRepositoryDecoratorBase<TraditionalDTO, Long> {

    public static final String MODIFIED_BY_DECORATOR = "Modified by traditional Decorator";

    @Override
    public <S extends TraditionalDTO> S save(S entity) {
        entity.setValue(MODIFIED_BY_DECORATOR);
        return super.save(entity);
    }
}
