package io.crnk.demo.jpa.computedvalue;

import io.crnk.core.engine.transaction.TransactionRunner;
import io.crnk.demo.jpa.computedvalue.plain.PlainEntity;
import io.crnk.demo.jpa.computedvalue.computed.ComputedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Configuration
public class InitSampleData {
    private EntityManager em;
    private TransactionRunner transactionRunner;

    @Autowired
    public InitSampleData(EntityManager em, TransactionRunner transactionRunner) {
        this.em = em;
        this.transactionRunner = transactionRunner;
    }

    @PostConstruct
    public void initData() {
        transactionRunner.doInTransaction(() -> {
            for (long i = 0; i < 10; i++) {
                PlainEntity plain = new PlainEntity( "Plain " + i);
                em.persist(plain);
            }
            for (long i = 0; i < 10; i++) {
                ComputedEntity computed = new ComputedEntity("Trad " + i);
                em.persist(computed);
            }
            return null;
        });
    }
}
