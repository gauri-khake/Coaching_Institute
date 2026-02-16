package com.asint.coaching.coaching.services;

import cds.gen.coaching.Enrollments;
import com.asint.coaching.coaching.repository.EnrollmentRepository;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ServiceName("CoachingService")
public class EnrollmentService implements EventHandler {

    private final PersistenceService db;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(PersistenceService db, EnrollmentRepository enrollmentRepository) {
        this.db = db;
        this.enrollmentRepository = enrollmentRepository;
    }

    @On(event = CqnService.EVENT_READ, entity = "CoachingService.Enrollments")
    public void onReadEnrollments(CdsReadEventContext context) {
        CqnSelect query = context.getCqn();

        List<String> studentIds = getStudentIdsFromContext(context);

        if (studentIds != null && !studentIds.isEmpty()) {
            List<Enrollments> enrollments = enrollmentRepository.getEnrollmentsWithPaymentsByStudentIds(studentIds);
            context.setResult(enrollments);
            context.setCompleted();
        }
    }

    private List<String> getStudentIdsFromContext(CdsReadEventContext context) {

        Map<String, Object> params = (Map<String, Object>) context.getParameterInfo();
        if (params != null && params.containsKey("studentIds")) {
            return (List<String>) params.get("studentIds");
        }
        return null;
    }
}
