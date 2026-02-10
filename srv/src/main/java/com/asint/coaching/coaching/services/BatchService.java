package com.asint.coaching.coaching.services;

import cds.gen.coaching.Batches;
import cds.gen.coaching.Batches_;
import com.asint.coaching.coaching.repository.BatchRepository;
import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.ServiceException;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ServiceName("BatchService")
public class BatchService implements EventHandler {

    private final BatchRepository batchRepository;

    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Before(event = CqnService.EVENT_UPDATE, entity = "BatchService.updateBatch")
    public void validateAndUpdateBatchTiming(List<Batches> batches) {

        for (Batches batch : batches) {
            String newTiming = batch.getTiming();

            if (newTiming != null && newTiming.trim().isEmpty()) {
                throw new ServiceException(
                        ErrorStatuses.BAD_REQUEST,
                        "Timing cannot be empty for batch: " + batch.getBatchCode()
                );
            }
        }
    }

    @On(event = CqnService.EVENT_UPDATE, entity = Batches_.CDS_NAME)
    public void onUpdateBatch(List<Batches> batches) {
        batchRepository.updateBatchTiming(batches);
    }
}

