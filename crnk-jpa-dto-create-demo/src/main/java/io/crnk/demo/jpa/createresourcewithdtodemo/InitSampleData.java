package io.crnk.demo.jpa.createresourcewithdtodemo;

import io.crnk.core.engine.transaction.TransactionRunner;
import io.crnk.demo.jpa.createresourcewithdtodemo.modern.ModernEntity;
import io.crnk.demo.jpa.createresourcewithdtodemo.traditional.TraditionalEntity;
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
                ModernEntity modern = new ModernEntity( "Test " + i);
                em.persist(modern);
            }
            for (long i = 0; i < 10; i++) {
                TraditionalEntity trad = new TraditionalEntity("Trad " + i);
                em.persist(trad);
            }
            return null;
        });
    }
}
