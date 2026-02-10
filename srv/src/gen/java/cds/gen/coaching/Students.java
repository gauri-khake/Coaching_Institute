package cds.gen.coaching;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("coaching.Students")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Students extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String ADMISSION_NO = "admissionNo";

  String FULL_NAME = "fullName";

  String PHONE = "phone";

  String PARENT_PHONE = "parentPhone";

  String BRANCH = "branch";

  String BRANCH_ID = "branch_ID";

  String TO_ENROLLMENTS = "to_enrollments";

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

  String getAdmissionNo();

  void setAdmissionNo(String admissionNo);

  String getFullName();

  void setFullName(String fullName);

  String getPhone();

  void setPhone(String phone);

  String getParentPhone();

  void setParentPhone(String parentPhone);

  Branches getBranch();

  void setBranch(Map<String, ?> branch);

  @CdsName(BRANCH_ID)
  String getBranchId();

  @CdsName(BRANCH_ID)
  void setBranchId(String branchId);

  @CdsName(TO_ENROLLMENTS)
  List<Enrollments> getToEnrollments();

  @CdsName(TO_ENROLLMENTS)
  void setToEnrollments(List<? extends Map<String, ?>> toEnrollments);

  Students_ ref();

  static Students create() {
    return Struct.create(Students.class);
  }

  static Students of(Map<String, Object> map) {
    return Struct.access(map).as(Students.class);
  }

  static Students create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Students.class);
  }
}
