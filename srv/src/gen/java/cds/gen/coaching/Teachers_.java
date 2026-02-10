package cds.gen.coaching;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Boolean;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("coaching.Teachers")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Teachers_ extends StructuredType<Teachers_> {
  String ID = "ID";

  String CDS_NAME = "coaching.Teachers";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  ElementRef<String> empCode();

  ElementRef<String> fullName();

  ElementRef<String> phone();

  ElementRef<String> email();

  ElementRef<LocalDate> joiningDate();

  ElementRef<Boolean> active();

  TeacherSubjects_ to_subjects();

  TeacherSubjects_ to_subjects(Function<TeacherSubjects_, CqnPredicate> filter);

  TeacherBatchAssignments_ to_batches();

  TeacherBatchAssignments_ to_batches(Function<TeacherBatchAssignments_, CqnPredicate> filter);
}
