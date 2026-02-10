package cds.gen.coaching;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("coaching.Enrollments")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Enrollments_ extends StructuredType<Enrollments_> {
  String ID = "ID";

  String STUDENT_ID = "student_ID";

  String BATCH_ID = "batch_ID";

  String CDS_NAME = "coaching.Enrollments";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  Students_ student();

  Students_ student(Function<Students_, CqnPredicate> filter);

  @CdsName(STUDENT_ID)
  ElementRef<String> student_ID();

  Batches_ batch();

  Batches_ batch(Function<Batches_, CqnPredicate> filter);

  @CdsName(BATCH_ID)
  ElementRef<String> batch_ID();

  ElementRef<LocalDate> enrollDate();

  ElementRef<BigDecimal> totalFees();

  ElementRef<BigDecimal> finalFees();

  ElementRef<String> status();

  FeePayments_ to_payments();

  FeePayments_ to_payments(Function<FeePayments_, CqnPredicate> filter);
}
