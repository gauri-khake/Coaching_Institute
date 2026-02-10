package cds.gen.coaching;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
@CdsName("coaching")
public interface Coaching_ {
  String CDS_NAME = "coaching";

  Class<TeacherBatchAssignments_> TEACHER_BATCH_ASSIGNMENTS = TeacherBatchAssignments_.class;

  Class<Subjects_> SUBJECTS = Subjects_.class;

  Class<Batches_> BATCHES = Batches_.class;

  Class<Enrollments_> ENROLLMENTS = Enrollments_.class;

  Class<Students_> STUDENTS = Students_.class;

  Class<FeePayments_> FEE_PAYMENTS = FeePayments_.class;

  Class<Courses_> COURSES = Courses_.class;

  Class<Branches_> BRANCHES = Branches_.class;

  Class<Teachers_> TEACHERS = Teachers_.class;

  Class<TeacherSubjects_> TEACHER_SUBJECTS = TeacherSubjects_.class;
}
