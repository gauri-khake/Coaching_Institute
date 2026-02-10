package cds.gen.cds.outbox;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import javax.annotation.processing.Generated;

@CdsName("cds.outbox.Messages")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Messages_ extends StructuredType<Messages_> {
  String ID = "ID";

  String CDS_NAME = "cds.outbox.Messages";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<Instant> timestamp();

  ElementRef<String> target();

  ElementRef<String> msg();

  ElementRef<Integer> attempts();

  ElementRef<Integer> partition();

  ElementRef<String> lastError();

  ElementRef<Instant> lastAttemptTimestamp();

  ElementRef<String> status();

  ElementRef<String> task();

  ElementRef<String> appid();
}
