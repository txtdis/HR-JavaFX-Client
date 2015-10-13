package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Leave;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class LeaveStartColumn extends DateColumn<Leave> {

    public LeaveStartColumn() {
        super("Start", "startDate");
    }
}
