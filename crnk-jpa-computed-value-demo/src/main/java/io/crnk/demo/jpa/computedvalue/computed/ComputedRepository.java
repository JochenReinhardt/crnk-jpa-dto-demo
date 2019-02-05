package io.crnk.demo.jpa.computedvalue.computed;

import io.crnk.core.resource.meta.DefaultHasMoreResourcesMetaInformation;
import io.crnk.demo.jpa.computedvalue.plain.PlainDTO;
import io.crnk.demo.jpa.computedvalue.plain.PlainEntity;
import io.crnk.demo.jpa.computedvalue.plain.PlainJpaMapper;
import io.crnk.jpa.JpaEntityRepositoryBase;
import io.crnk.jpa.JpaModule;
import io.crnk.jpa.JpaRepositoryConfig;
import io.crnk.jpa.query.JpaQueryFactory;
import io.crnk.jpa.query.criteria.JpaCriteriaExpressionFactory;
import io.crnk.jpa.query.criteria.JpaCriteriaQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;

@Component
public class ComputedRepository extends JpaEntityRepositoryBase<ComputedDTO, Long> {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ComputedRepository(ComputedJpaMapper mapper) {
        super(JpaRepositoryConfig.builder(ComputedEntity.class, ComputedDTO.class, mapper)
                .setListMetaClass(DefaultHasMoreResourcesMetaInformation.class)
                .build());
    }
}
