package com.asint.coaching.coaching.repository;

import cds.gen.coaching.Students;
import cds.gen.coaching.Students_;
import com.sap.cds.ql.Delete;
import com.sap.cds.ql.Insert;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.Update;
import com.sap.cds.ql.cqn.CqnDelete;
import com.sap.cds.ql.cqn.CqnSelect;
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

    public void insertStudents(List<Students> students) {
        db.run(Insert.into(Students_.CDS_NAME).entries(students));
    }

    public void updateStudent(Students student) {
        db.run(Update.entity(Students_.CDS_NAME)
                .data(student)
                .where(s -> s.get("ID").eq(student.getId())));
    }

    public boolean studentExists(String admissionNo) {
        CqnSelect query = Select.from(Students_.CDS_NAME)
                .where(s -> s.get("admissionNo").eq(admissionNo));
        return db.run(query).rowCount() > 0;
    }

    public Students getStudentByAdmissionNo(String admissionNo) {
        CqnSelect query = Select.from(Students_.CDS_NAME)
                .where(s -> s.get("admissionNo").eq(admissionNo));
        return db.run(query).single(Students.class);
    }

}
