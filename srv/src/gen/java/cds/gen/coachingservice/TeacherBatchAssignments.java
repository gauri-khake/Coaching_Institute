package cds.gen.coachingservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("CoachingService.TeacherBatchAssignments")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface TeacherBatchAssignments extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String TEACHER = "teacher";

  String TEACHER_ID = "teacher_ID";

  String BATCH = "batch";

  String BATCH_ID = "batch_ID";

  String ROLE = "role";

  String ASSIGNED_ON = "assignedOn";

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

  Teachers getTeacher();

  void setTeacher(Map<String, ?> teacher);

  @CdsName(TEACHER_ID)
  String getTeacherId();

  @CdsName(TEACHER_ID)
  void setTeacherId(String teacherId);

  Batches getBatch();

  void setBatch(Map<String, ?> batch);

  @CdsName(BATCH_ID)
  String getBatchId();

  @CdsName(BATCH_ID)
  void setBatchId(String batchId);

  String getRole();

  void setRole(String role);

  LocalDate getAssignedOn();

  void setAssignedOn(LocalDate assignedOn);

  TeacherBatchAssignments_ ref();

  static TeacherBatchAssignments create() {
    return Struct.create(TeacherBatchAssignments.class);
  }

  static TeacherBatchAssignments of(Map<String, Object> map) {
    return Struct.access(map).as(TeacherBatchAssignments.class);
  }

  static TeacherBatchAssignments create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(TeacherBatchAssignments.class);
  }
}
