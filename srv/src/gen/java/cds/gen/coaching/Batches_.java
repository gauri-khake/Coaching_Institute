package cds.gen.coaching;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("coaching.Batches")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Batches_ extends StructuredType<Batches_> {
  String ID = "ID";

  String BRANCH_ID = "branch_ID";

  String COURSE_ID = "course_ID";

  String CDS_NAME = "coaching.Batches";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  ElementRef<String> batchCode();

  ElementRef<LocalDate> startDate();

  ElementRef<String> timing();

  ElementRef<Integer> maxStrength();

  Branches_ branch();

  Branches_ branch(Function<Branches_, CqnPredicate> filter);

  @CdsName(BRANCH_ID)
  ElementRef<String> branch_ID();

  Courses_ course();

  Courses_ course(Function<Courses_, CqnPredicate> filter);

  @CdsName(COURSE_ID)
  ElementRef<String> course_ID();
}
