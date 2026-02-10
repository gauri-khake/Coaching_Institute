package cds.gen.sap.common;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("sap.common.FlowHistory")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface FlowHistory_ extends StructuredType<FlowHistory_> {
  String CDS_NAME = "sap.common.FlowHistory";

  Transitions_ transitions_();

  Transitions_ transitions_(Function<Transitions_, CqnPredicate> filter);

  interface Transitions_ extends StructuredType<Transitions_> {
    ElementRef<Instant> timestamp();

    ElementRef<String> user();

    ElementRef<String> status();

    ElementRef<String> comment();
  }
}
