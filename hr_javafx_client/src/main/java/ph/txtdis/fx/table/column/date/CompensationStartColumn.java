package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Compensation;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class CompensationStartColumn extends DateColumn<Compensation> {

    public CompensationStartColumn() {
        super("Start", "startDate");
    }
}
