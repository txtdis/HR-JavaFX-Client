package ph.txtdis.dto;

import java.time.ZonedDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractAuditedNumbered extends AbstractNumbered
        implements Audited {

    protected String createdBy;

    protected ZonedDateTime createdOn;
}