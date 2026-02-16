package com.asint.coaching.coaching.services;

import cds.gen.coaching.Batches;
import cds.gen.coaching.Batches_;
import com.asint.coaching.coaching.repository.BatchRepository;
import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.ServiceException;
import com.sap.cds.services.cds.CdsUpdateEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ServiceName("CoachingService")
public class BatchService implements EventHandler {

    private final PersistenceService db;
    private final BatchRepository batchRepository;

    public BatchService(PersistenceService db, BatchRepository batchRepository) {
        this.db = db;
        this.batchRepository = batchRepository;
    }

    @Before(event = CqnService.EVENT_UPDATE, entity = "CoachingService.Batches")
    public void beforeUpdateBatch(List<Batches> batches) {
        for (Batches batch : batches) {
            if (batch.getBatchCode() != null && batch.getBatchCode().trim().isEmpty()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Batch code cannot be empty");
            }

            if (batch.getMaxStrength() != null && batch.getMaxStrength() < 0) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Max strength cannot be negative");
            }
        }
    }

    @On(event = CqnService.EVENT_UPDATE, entity = "CoachingService.Batches")
    public void onUpdateBatch(List<Batches> batches, CdsUpdateEventContext context) {
        for (Batches batch : batches) {
            batchRepository.updateBatch(batch);
        }

        context.setResult(batches);
        context.setCompleted();
    }
}
