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

@CdsName("coaching.FeePayments")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface FeePayments_ extends StructuredType<FeePayments_> {
  String ID = "ID";

  String ENROLLMENT_ID = "enrollment_ID";

  String CDS_NAME = "coaching.FeePayments";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  Enrollments_ enrollment();

  Enrollments_ enrollment(Function<Enrollments_, CqnPredicate> filter);

  @CdsName(ENROLLMENT_ID)
  ElementRef<String> enrollment_ID();

  ElementRef<BigDecimal> amount();

  ElementRef<LocalDate> paymentDate();

  ElementRef<String> mode();

  ElementRef<String> receiptNo();
}
