package com.asint.coaching.coaching.services;

import com.asint.coaching.coaching.repository.EnrollmentRepository;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ServiceName("CoachingService")
public class EnrollmentService implements EventHandler {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @On(event = CqnService.EVENT_READ, entity = "EnrollmentService.readEnrollmentsWithPayments")
    public List<Map<String,Object>> readEnrollmentsWithPayments(Map<String, Object> data) {

        List<String> studentIds = (List<String>) data.get("studentIds");

        return enrollmentRepository.readEnrollmentsWithPayments(studentIds);
    }
}
