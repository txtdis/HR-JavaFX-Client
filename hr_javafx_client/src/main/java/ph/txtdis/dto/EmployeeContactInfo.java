package ph.txtdis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ph.txtdis.type.ContactInfoType;
import ph.txtdis.util.Numeric;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployeeContactInfo extends AbstractAuditedNumbered {

    private ContactInfoType type;

    private String detail;

    public String getDetail() {
        if (type.toString().contains("PHONE"))
            return Numeric.displayPhone(detail);
        return detail;
    }

    public void setDetail(String detail) {
        if (type.toString().contains("PHONE"))
            this.detail = Numeric.persistPhone(detail);
        this.detail = detail;
    }
}
