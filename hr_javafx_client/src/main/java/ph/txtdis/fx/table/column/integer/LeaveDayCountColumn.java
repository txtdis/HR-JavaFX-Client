package ph.txtdis.fx.table.column.integer;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Leave;
import ph.txtdis.fx.table.column.IntegerColumn;

@Component
public class LeaveDayCountColumn extends IntegerColumn<Leave> {

    public LeaveDayCountColumn() {
        super("No. of Days", "dayCount");
    }
}
