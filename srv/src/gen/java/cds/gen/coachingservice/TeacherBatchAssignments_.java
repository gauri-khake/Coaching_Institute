package cds.gen.coachingservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("CoachingService.TeacherBatchAssignments")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface TeacherBatchAssignments_ extends StructuredType<TeacherBatchAssignments_> {
  String ID = "ID";

  String TEACHER_ID = "teacher_ID";

  String BATCH_ID = "batch_ID";

  String CDS_NAME = "CoachingService.TeacherBatchAssignments";

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

  Batches_ batch();

  Batches_ batch(Function<Batches_, CqnPredicate> filter);

  @CdsName(BATCH_ID)
  ElementRef<String> batch_ID();

  ElementRef<String> role();

  ElementRef<LocalDate> assignedOn();
}
