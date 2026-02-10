package com.asint.coaching.coaching.services;


import cds.gen.coaching.Students;
import cds.gen.coaching.Students_;
import com.asint.coaching.coaching.repository.StudentRepository;
import com.sap.cds.ql.Insert;
import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.ServiceException;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
    public void validateAndDefaultStudents(List<Students> students) {

        if (students == null || students.isEmpty()) {
            throw new ServiceException(ErrorStatuses.BAD_REQUEST, "No students provided in batch");
        }

        for (Students student : students) {
            String admissionNo = student.getAdmissionNo();
            if (admissionNo == null || admissionNo.trim().isEmpty()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                        "Admission number is required for student: " + student.getFullName());
            }

            if (student.getFullName() == null || student.getFullName().trim().isEmpty()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Full name is required");
            }
        }
    }

    @On(event = CqnService.EVENT_CREATE, entity = "StudentService.Students")
    public void onCreateStudents(CdsCreateEventContext context) {
        List<Map<String, Object>> students = context.getCqn().entries();

        if (students == null || students.isEmpty()) {
            throw new ServiceException(ErrorStatuses.BAD_REQUEST, "No students provided in batch");
        }

        for (Map<String, Object> student : students) {
            String admissionNo = (String) student.get("admissionNo");
            if (admissionNo == null || admissionNo.trim().isEmpty()) {
                String fullName = (String) student.get("fullName");
                throw new ServiceException(ErrorStatuses.BAD_REQUEST,
                        "Admission number is required for student: " +
                                (fullName != null ? fullName : "unknown"));
            }

            String fullName = (String) student.get("fullName");
            if (fullName == null || fullName.trim().isEmpty()) {
                throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Full name is required");
            }
        }

        db.run(Insert.into(Students_.CDS_NAME).entries(students));

        context.setResult(students);
    }

    @On(event = CqnService.EVENT_DELETE, entity = "StudentService.deleteStudents")
    public Boolean deleteStudents(Map<String, Object> payload) {

        List<String> studentIds = (List<String>) payload.get("studentIds");

        studentRepository.deleteStudents(studentIds);

        return true;

    }
}