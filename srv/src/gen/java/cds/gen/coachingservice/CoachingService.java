package cds.gen.coachingservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.services.cds.ApplicationService;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.cds.RemoteService;
import javax.annotation.processing.Generated;

@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
@CdsName(CoachingService_.CDS_NAME)
public interface CoachingService extends CqnService {
  interface Application extends ApplicationService, CoachingService {
  }

  interface Remote extends RemoteService, CoachingService {
  }
}
