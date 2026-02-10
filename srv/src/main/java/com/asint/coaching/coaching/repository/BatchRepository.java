package com.asint.coaching.coaching.repository;

import cds.gen.coaching.Batches;
import cds.gen.coaching.Batches_;
import com.sap.cds.ql.Update;
import com.sap.cds.services.persistence.PersistenceService;

import java.util.List;

public class BatchRepository {
    private final PersistenceService db;

    public BatchRepository(PersistenceService db) {
        this.db = db;
    }

    public void updateBatchTiming(List<Batches> batches) {

        for (Batches batch : batches) {
            if (batch.getTiming() != null) {
                db.run(
                        Update.entity(Batches_.CDS_NAME)
                                .data("timing", batch.getTiming())
                                .byId(batch.getId())
                );
            }
        }
    }
}
