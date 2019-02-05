package io.crnk.demo.jpa.computedvalue.computed;

import io.crnk.jpa.mapping.JpaMapper;
import io.crnk.jpa.query.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ComputedJpaMapper implements JpaMapper<ComputedEntity, ComputedDTO> {
    private EntityManager entityManager;

    @Autowired
    public ComputedJpaMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ComputedDTO map(Tuple tuple) {
        ComputedEntity entity = tuple.get(0, ComputedEntity.class);
        ComputedDTO dto = new ComputedDTO();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        dto.setComputedValue(tuple.get(1, String.class));
        return dto;
    }

    @Override
    public ComputedEntity unmap(ComputedDTO dto) {
        ComputedEntity entity;
        if (dto.getId() == null) {
            entity = new ComputedEntity();
        } else {
            entity = entityManager.find(ComputedEntity.class, dto.getId());
        }
        entity.setValue(dto.getValue());
        return entity;
    }
}
