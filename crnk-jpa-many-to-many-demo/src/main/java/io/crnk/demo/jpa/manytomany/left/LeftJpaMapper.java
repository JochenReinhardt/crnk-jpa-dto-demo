package io.crnk.demo.jpa.manytomany.left;

import io.crnk.jpa.mapping.JpaMapper;
import io.crnk.jpa.query.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class LeftJpaMapper implements JpaMapper<LeftEntity, LeftDTO> {
    private EntityManager entityManager;

    @Autowired
    public LeftJpaMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public LeftDTO map(Tuple tuple) {
        LeftEntity entity = tuple.get(0, LeftEntity.class);
        LeftDTO dto = new LeftDTO();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        return dto;
    }

    @Override
    public LeftEntity unmap(LeftDTO dto) {
        LeftEntity entity;
        if (dto.getId() == null) {
            entity = new LeftEntity();
        } else {
            entity = entityManager.find(LeftEntity.class, dto.getId());
        }
        entity.setValue(dto.getValue());
        return entity;
    }
}
