package io.crnk.demo.jpa.createresourcewithdtodemo.traditional;

import io.crnk.jpa.mapping.JpaMapper;
import io.crnk.jpa.query.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class TraditionalJpaMapper implements JpaMapper<TraditionalEntity, TraditionalDTO> {
    private EntityManager entityManager;

    @Autowired
    public TraditionalJpaMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public TraditionalDTO map(Tuple tuple) {
        TraditionalEntity entity = tuple.get(0, TraditionalEntity.class);
        TraditionalDTO dto = new TraditionalDTO();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        return dto;
    }

    @Override
    public TraditionalEntity unmap(TraditionalDTO dto) {
        TraditionalEntity entity;
        if (dto.getId() == null) {
            entity = new TraditionalEntity();
        } else {
            entity = entityManager.find(TraditionalEntity.class, dto.getId());
        }
        entity.setValue(dto.getValue());
        return entity;
    }
}
