package ph.txtdis.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ph.txtdis.type.LeaveType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Leave extends AbstractAuditedNumbered {

    private LeaveType type;

    private LocalDate startDate;

    private Integer dayCount;
}
