package ph.txtdis.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PastWork extends AbstractAuditedNumbered {

    private LocalDate startDate;

    private LocalDate endDate;

    private String employer;

    private String designation;

    private BigDecimal lastPayValue;

    private String reasonForLeaving;

    private String referenceName;

    private String referenceDesignation;

    private String referencePhone;
}
