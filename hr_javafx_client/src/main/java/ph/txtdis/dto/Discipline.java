package ph.txtdis.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Discipline extends AbstractAuditedNumbered {

    private LocalDate incidenceDate;

    private String allegation;

    private String decision;

    private LocalDate effectivityDate;

    private Integer dayCount;

    private boolean noticeGiven;

    private boolean replyReceived;

    private boolean decisionGiven;

    public Discipline(LocalDate incidence, String allegation) {
        this.incidenceDate = incidence;
        this.allegation = allegation;
    }
}
