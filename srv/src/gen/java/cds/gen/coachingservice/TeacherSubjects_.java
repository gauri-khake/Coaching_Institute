package cds.gen.coachingservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("CoachingService.TeacherSubjects")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface TeacherSubjects_ extends StructuredType<TeacherSubjects_> {
  String ID = "ID";

  String TEACHER_ID = "teacher_ID";

  String SUBJECT_ID = "subject_ID";

  String CDS_NAME = "CoachingService.TeacherSubjects";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  Teachers_ teacher();

  Teachers_ teacher(Function<Teachers_, CqnPredicate> filter);

  @CdsName(TEACHER_ID)
  ElementRef<String> teacher_ID();

  Subjects_ subject();

  Subjects_ subject(Function<Subjects_, CqnPredicate> filter);

  @CdsName(SUBJECT_ID)
  ElementRef<String> subject_ID();
}
