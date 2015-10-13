package ph.txtdis.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Assignment extends AbstractAuditedNumbered {

    private LocalDate startDate;

    private LocalDate endDate;

    private String location;

    private String designation;

    public Assignment(LocalDate startDate, String location,
            String designation) {
        this.startDate = startDate;
        this.location = location;
        this.designation = designation;
    }
}
