package ph.txtdis.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Style extends AbstractAuditedNumbered {

    private String base, background, accent, font;
}
