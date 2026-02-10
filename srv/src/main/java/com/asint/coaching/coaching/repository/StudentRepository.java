package com.asint.coaching.coaching.repository;

import com.sap.cds.ql.Delete;
import com.sap.cds.ql.cqn.CqnDelete;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final PersistenceService db;

    public StudentRepository(PersistenceService db) {
        this.db = db;
    }

    public void deleteStudents(List<String> studentIds) {

        if (studentIds == null || studentIds.isEmpty()) {
            return;
        }

        CqnDelete delete = Delete.from("coaching.Students")
                .where(s -> s.get("ID").in(studentIds));

        db.run(delete);
    }
}
