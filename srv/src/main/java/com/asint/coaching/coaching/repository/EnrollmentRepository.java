package com.asint.coaching.coaching.repository;

import cds.gen.coaching.Enrollments;
import com.sap.cds.Result;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnrollmentRepository {

    private final PersistenceService db;

    public EnrollmentRepository(PersistenceService db) {
        this.db = db;
    }

    public List<Enrollments> getEnrollmentsWithPaymentsByStudentIds(List<String> studentIds) {
        CqnSelect query = Select.from("CoachingService.Enrollments")
                .where(e -> e.get("student_ID").in(studentIds));

        Result result = db.run(query);
        return result.listOf(Enrollments.class);
    }
}

