package io.crnk.demo.jpa.manytomany.left;

import io.crnk.core.engine.internal.utils.MultivaluedMap;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.BulkRelationshipRepositoryV2;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.demo.jpa.manytomany.right.RightDTO;
import io.crnk.demo.jpa.manytomany.right.RightEntity;
import io.crnk.demo.jpa.manytomany.right.RightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LeftRightRelationRepository implements BulkRelationshipRepositoryV2<LeftDTO, Long, RightDTO, Long> {
    @PersistenceContext
    private EntityManager em;

    private RightRepository rightRepository;

    @Autowired
    public LeftRightRelationRepository(RightRepository rightRepository) {
        this.rightRepository = rightRepository;
    }

    @Override
    public MultivaluedMap<Long, RightDTO> findTargets(Iterable<Long> sourceIds, String fieldName, QuerySpec querySpec) {
        MultivaluedMap<Long, RightDTO> result = new MultivaluedMap<>();
        sourceIds.forEach(id -> {
            LeftEntity left = em.find(LeftEntity.class, id);
            List<Long> rightIds = left.getRights().stream()
                    .map(RightEntity::getId)
                    .collect(Collectors.toList());
            ResourceList<RightDTO> rights = rightRepository.findAll(rightIds, new QuerySpec(RightDTO.class));
            result.set(id, rights);
        });
        return result;
    }


    @Override
    public Class<LeftDTO> getSourceResourceClass() {
        return LeftDTO.class;
    }

    @Override
    public Class<RightDTO> getTargetResourceClass() {
        return RightDTO.class;
    }

    @Override
    public void setRelation(LeftDTO source, Long targetId, String fieldName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRelations(LeftDTO source, Iterable<Long> targetIds, String fieldName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addRelations(LeftDTO source, Iterable<Long> targetIds, String fieldName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeRelations(LeftDTO source, Iterable<Long> targetIds, String fieldName) {
        throw new UnsupportedOperationException();
    }
}
