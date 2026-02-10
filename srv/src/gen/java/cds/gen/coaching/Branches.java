package cds.gen.coaching;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("coaching.Branches")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface Branches extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String BRANCH_CODE = "branchCode";

  String NAME = "name";

  String CITY = "city";

  String ACTIVE = "active";

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

  String getBranchCode();

  void setBranchCode(String branchCode);

  String getName();

  void setName(String name);

  String getCity();

  void setCity(String city);

  Boolean getActive();

  void setActive(Boolean active);

  @CdsName(TO_BATCHES)
  List<Batches> getToBatches();

  @CdsName(TO_BATCHES)
  void setToBatches(List<? extends Map<String, ?>> toBatches);

  Branches_ ref();

  static Branches create() {
    return Struct.create(Branches.class);
  }

  static Branches of(Map<String, Object> map) {
    return Struct.access(map).as(Branches.class);
  }

  static Branches create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Branches.class);
  }
}
