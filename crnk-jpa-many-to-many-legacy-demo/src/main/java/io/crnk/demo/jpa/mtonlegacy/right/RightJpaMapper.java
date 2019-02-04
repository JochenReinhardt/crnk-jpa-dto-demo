package io.crnk.demo.jpa.mtonlegacy.right;

import io.crnk.jpa.mapping.JpaMapper;
import io.crnk.jpa.query.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class RightJpaMapper implements JpaMapper<RightEntity, RightDTO> {
    private EntityManager entityManager;

    @Autowired
    public RightJpaMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public RightDTO map(Tuple tuple) {
        RightEntity entity = tuple.get(0, RightEntity.class);
        RightDTO dto = new RightDTO();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        return dto;
    }

    @Override
    public RightEntity unmap(RightDTO dto) {
        RightEntity entity;
        if (dto.getId() == null) {
            entity = new RightEntity();
        } else {
            entity = entityManager.find(RightEntity.class, dto.getId());
        }
        entity.setValue(dto.getValue());
        return entity;
    }
}
