package com.asint.coaching.coaching.services;

import cds.gen.coaching.Students;
import cds.gen.coaching.Students_;
import com.asint.coaching.coaching.repository.StudentRepository;
import com.sap.cds.ql.Insert;
import com.sap.cds.ql.cqn.CqnDelete;
import com.sap.cds.ql.cqn.CqnInsert;
import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.ServiceException;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsDeleteEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@ServiceName("StudentService")
public class StudentService implements EventHandler {

    private final PersistenceService db;
    private final StudentRepository studentRepository;

    public StudentService(PersistenceService db, StudentRepository studentRepository) {
        this.db = db;
        this.studentRepository = studentRepository;
    }

    @Before(event = CqnService.EVENT_CREATE, entity = "StudentService.Students")
    public void beforeCreateStudent(List<Students> students) {
        for (Students student : students) {
            if (student.getFullName() == null || student.getFullName().trim().isEmpty()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Full name is required");
            }

            if (student.getPhone() == null || student.getPhone().trim().isEmpty()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Phone number is required");
            }
        }
    }

    @On(event = CqnService.EVENT_CREATE, entity = "StudentService.Students")
    public void onCreateStudent(CdsCreateEventContext context) {

        List<Map<String, Object>> entries = context.getCqn().entries();

        if (entries == null || entries.isEmpty()) {
            context.setCompleted();
            return;
        }

        entries.forEach(entry -> {
            entry.putIfAbsent("ID", UUID.randomUUID().toString());
        });

        CqnInsert insert = Insert.into("coaching.Students").entries(entries);
        db.run(insert);

        context.setResult(entries);

        context.setCompleted();
    }

    @Before(event = CqnService.EVENT_DELETE, entity = "StudentService.Students")
    public void beforeDeleteStudent(CdsDeleteEventContext context) {
        System.out.println("Before delete students");
    }

    @On(event = CqnService.EVENT_DELETE, entity = "StudentService.Students")
    public void onDeleteStudent(CdsDeleteEventContext context) {
        CqnDelete delete = context.getCqn();
        db.run(delete);

        context.setCompleted();
        System.out.println("Students deleted successfully");
    }
}
