package io.crnk.demo.jpa.repositorydecorator.modern;

import io.crnk.jpa.mapping.JpaMapper;
import io.crnk.jpa.query.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ModernJpaMapper implements JpaMapper<ModernEntity, ModernDTO> {
    private EntityManager entityManager;

    @Autowired
    public ModernJpaMapper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public ModernDTO map(Tuple tuple) {
        ModernEntity entity = tuple.get(0, ModernEntity.class);
        ModernDTO dto = new ModernDTO();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        return dto;
    }

    @Override
    public ModernEntity unmap(ModernDTO dto) {
        ModernEntity entity;
        if (dto.getId() == null) {
            entity = new ModernEntity();
        } else {
            entity = entityManager.find(ModernEntity.class, dto.getId());
        }
        entity.setValue(dto.getValue());
        return entity;
    }
}
