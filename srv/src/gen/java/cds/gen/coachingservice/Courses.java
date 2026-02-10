package cds.gen.coachingservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("CoachingService.Courses")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Courses extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String COURSE_CODE = "courseCode";

  String NAME = "name";

  String TARGET_EXAM = "targetExam";

  String DURATION_MONTHS = "durationMonths";

  String TOTAL_FEES = "totalFees";

  String TO_BATCHES = "to_batches";

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);

  Instant getCreatedAt();

  void setCreatedAt(Instant createdAt);

  String getCreatedBy();

  void setCreatedBy(String createdBy);

  Instant getModifiedAt();

  void setModifiedAt(Instant modifiedAt);

  String getModifiedBy();

  void setModifiedBy(String modifiedBy);

  String getCourseCode();

  void setCourseCode(String courseCode);

  String getName();

  void setName(String name);

  String getTargetExam();

  void setTargetExam(String targetExam);

  Integer getDurationMonths();

  void setDurationMonths(Integer durationMonths);

  BigDecimal getTotalFees();

  void setTotalFees(BigDecimal totalFees);

  @CdsName(TO_BATCHES)
  List<Batches> getToBatches();

  @CdsName(TO_BATCHES)
  void setToBatches(List<? extends Map<String, ?>> toBatches);

  Courses_ ref();

  static Courses create() {
    return Struct.create(Courses.class);
  }

  static Courses of(Map<String, Object> map) {
    return Struct.access(map).as(Courses.class);
  }

  static Courses create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Courses.class);
  }
}
