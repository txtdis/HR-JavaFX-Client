package ph.txtdis.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Education extends AbstractAuditedNumbered {

    private LocalDate startDate;

    private LocalDate endDate;

    private String institution;

    private String program;

    private String highestHonor;
}
