package io.crnk.demo.jpa.mtonlegacy;

import io.crnk.core.engine.transaction.TransactionRunner;
import io.crnk.demo.jpa.mtonlegacy.left.LeftEntity;
import io.crnk.demo.jpa.mtonlegacy.right.RightEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

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
            em.joinTransaction();
            List<LeftEntity> lefts = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                LeftEntity left = new LeftEntity(i, "Left " + i);
                em.persist(left);
                lefts.add(left);
            }
            for (int i = 0; i < 10; i++) {
                RightEntity right = new RightEntity(i, "Right " + i);
                em.persist(right);
                List<LeftEntity> correspondingLefts = lefts.subList(i, 10);
                right.getLefts().addAll(correspondingLefts);
                correspondingLefts.forEach(l -> l.getRights().add(right));
            }
            return null;
        });

    }
}
