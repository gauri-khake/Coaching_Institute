package com.asint.coaching.coaching.repository;

import cds.gen.coaching.Batches;
import com.sap.cds.ql.Update;
import com.sap.cds.ql.cqn.CqnUpdate;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.stereotype.Repository;

@Repository
public class BatchRepository {
    private final PersistenceService db;

    public BatchRepository(PersistenceService db) {
        this.db = db;
    }

    public void updateBatch(Batches batch) {
        CqnUpdate update = Update.entity("CoachingService.Batches")
                .data(batch)
                .where(b -> b.get("ID").eq(batch.getId()));
        db.run(update);
    }
}
