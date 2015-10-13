package ph.txtdis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AbstractNumbered implements Keyed<Long> {

    protected Long id;
}