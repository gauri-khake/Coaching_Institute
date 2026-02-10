package cds.gen.coaching;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("coaching.Batches")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Batches extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String BATCH_CODE = "batchCode";

  String START_DATE = "startDate";

  String TIMING = "timing";

  String MAX_STRENGTH = "maxStrength";

  String BRANCH = "branch";

  String BRANCH_ID = "branch_ID";

  String COURSE = "course";

  String COURSE_ID = "course_ID";

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

  String getBatchCode();

  void setBatchCode(String batchCode);

  LocalDate getStartDate();

  void setStartDate(LocalDate startDate);

  String getTiming();

  void setTiming(String timing);

  Integer getMaxStrength();

  void setMaxStrength(Integer maxStrength);

  Branches getBranch();

  void setBranch(Map<String, ?> branch);

  @CdsName(BRANCH_ID)
  String getBranchId();

  @CdsName(BRANCH_ID)
  void setBranchId(String branchId);

  Courses getCourse();

  void setCourse(Map<String, ?> course);

  @CdsName(COURSE_ID)
  String getCourseId();

  @CdsName(COURSE_ID)
  void setCourseId(String courseId);

  Batches_ ref();

  static Batches create() {
    return Struct.create(Batches.class);
  }

  static Batches of(Map<String, Object> map) {
    return Struct.access(map).as(Batches.class);
  }

  static Batches create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Batches.class);
  }
}
