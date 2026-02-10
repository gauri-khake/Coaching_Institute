package cds.gen;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("temporal")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Temporal extends CdsData {
  String VALID_FROM = "validFrom";

  String VALID_TO = "validTo";

  Instant getValidFrom();

  void setValidFrom(Instant validFrom);

  Instant getValidTo();

  void setValidTo(Instant validTo);

  static Temporal create() {
    return Struct.create(Temporal.class);
  }

  static Temporal of(Map<String, Object> map) {
    return Struct.access(map).as(Temporal.class);
  }
}
