package io.crnk.demo.jpa.computedvalue.plain;

import io.crnk.jpa.mapping.JpaMapper;
import io.crnk.jpa.query.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class PlainJpaMapper implements JpaMapper<PlainEntity, PlainDTO> {
    private EntityManager entityManager;

    @Autowired
    public PlainJpaMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PlainDTO map(Tuple tuple) {
        PlainEntity entity = tuple.get(0, PlainEntity.class);
        PlainDTO dto = new PlainDTO();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        return dto;
    }

    @Override
    public PlainEntity unmap(PlainDTO dto) {
        PlainEntity entity;
        if (dto.getId() == null) {
            entity = new PlainEntity();
        } else {
            entity = entityManager.find(PlainEntity.class, dto.getId());
        }
        entity.setValue(dto.getValue());
        return entity;
    }
}
