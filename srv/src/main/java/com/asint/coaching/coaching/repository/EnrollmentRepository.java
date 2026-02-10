package com.asint.coaching.coaching.repository;

import cds.gen.coaching.Enrollments_;
import com.sap.cds.Result;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EnrollmentRepository {

    private final PersistenceService db;

    public EnrollmentRepository(PersistenceService db) {
        this.db = db;
    }

    public List<Map<String, Object>> readEnrollmentsWithPayments(List<String> studentIds) {

        if (studentIds == null || studentIds.isEmpty()) {
            return List.of();
        }

        CqnSelect select = Select.from("coaching.Enrollments")
                .where(e -> e.get("student_ID").in(studentIds));

        Result result = db.run(select);

        return result.listOf(Map.class)
                .stream()
                .map(m -> (Map<String, Object>) m)
                .collect(Collectors.toList());
    }
}
