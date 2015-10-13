package ph.txtdis.fx.table.column.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Leave;
import ph.txtdis.fx.table.column.ComboColumn;
import ph.txtdis.type.LeaveType;

@Component
public class LeaveTypeColumn extends ComboColumn<Leave, LeaveType> {

    public LeaveTypeColumn() {
        super("Type", "type", LeaveType.values(), 100);
    }
}
