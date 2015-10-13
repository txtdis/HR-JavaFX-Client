package ph.txtdis.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ph.txtdis.type.GovtIdType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GovtId extends AbstractAuditedNumbered {

    private byte[] image;

    private GovtIdType type;

    private LocalDate issuanceDate;

    private LocalDate expiryDate;

    private String detail;
}
