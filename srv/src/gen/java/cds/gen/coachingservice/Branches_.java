package cds.gen.coachingservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Boolean;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("CoachingService.Branches")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Branches_ extends StructuredType<Branches_> {
  String ID = "ID";

  String CDS_NAME = "CoachingService.Branches";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> createdAt();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  ElementRef<String> modifiedBy();

  ElementRef<String> branchCode();

  ElementRef<String> name();

  ElementRef<String> city();

  ElementRef<Boolean> active();

  Batches_ to_batches();

  Batches_ to_batches(Function<Batches_, CqnPredicate> filter);
}
