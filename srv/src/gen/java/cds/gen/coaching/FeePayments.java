package cds.gen.coaching;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("coaching.FeePayments")
@Generated(
    value = "cds-maven-plugin",
    date = "2026-02-10T07:26:05.158531900Z",
    comments = "com.sap.cds:cds-maven-plugin:3.8.0 / com.sap.cds:cds4j-api:3.8.0"
)
public interface FeePayments extends CdsData {
  String ID = "ID";

  String CREATED_AT = "createdAt";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String MODIFIED_BY = "modifiedBy";

  String ENROLLMENT = "enrollment";

  String ENROLLMENT_ID = "enrollment_ID";

  String AMOUNT = "amount";

  String PAYMENT_DATE = "paymentDate";

  String MODE = "mode";

  String RECEIPT_NO = "receiptNo";

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

  Enrollments getEnrollment();

  void setEnrollment(Map<String, ?> enrollment);

  @CdsName(ENROLLMENT_ID)
  String getEnrollmentId();

  @CdsName(ENROLLMENT_ID)
  void setEnrollmentId(String enrollmentId);

  BigDecimal getAmount();

  void setAmount(BigDecimal amount);

  LocalDate getPaymentDate();

  void setPaymentDate(LocalDate paymentDate);

  String getMode();

  void setMode(String mode);

  String getReceiptNo();

  void setReceiptNo(String receiptNo);

  FeePayments_ ref();

  static FeePayments create() {
    return Struct.create(FeePayments.class);
  }

  static FeePayments of(Map<String, Object> map) {
    return Struct.access(map).as(FeePayments.class);
  }

  static FeePayments create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(FeePayments.class);
  }
}
