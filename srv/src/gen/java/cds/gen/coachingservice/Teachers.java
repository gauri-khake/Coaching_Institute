package cds.gen.coachingservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("CoachingService.Teachers")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Teachers extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String EMP_CODE = "empCode";

  String FULL_NAME = "fullName";

  String PHONE = "phone";

  String EMAIL = "email";

  String JOINING_DATE = "joiningDate";

  String ACTIVE = "active";

  String TO_SUBJECTS = "to_subjects";

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

  String getEmpCode();

  void setEmpCode(String empCode);

  String getFullName();

  void setFullName(String fullName);

  String getPhone();

  void setPhone(String phone);

  String getEmail();

  void setEmail(String email);

  LocalDate getJoiningDate();

  void setJoiningDate(LocalDate joiningDate);

  Boolean getActive();

  void setActive(Boolean active);

  @CdsName(TO_SUBJECTS)
  List<TeacherSubjects> getToSubjects();

  @CdsName(TO_SUBJECTS)
  void setToSubjects(List<? extends Map<String, ?>> toSubjects);

  @CdsName(TO_BATCHES)
  List<TeacherBatchAssignments> getToBatches();

  @CdsName(TO_BATCHES)
  void setToBatches(List<? extends Map<String, ?>> toBatches);

  Teachers_ ref();

  static Teachers create() {
    return Struct.create(Teachers.class);
  }

  static Teachers of(Map<String, Object> map) {
    return Struct.access(map).as(Teachers.class);
  }

  static Teachers create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Teachers.class);
  }
}
