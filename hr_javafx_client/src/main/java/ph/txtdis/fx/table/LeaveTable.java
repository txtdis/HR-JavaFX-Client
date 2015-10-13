package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Leave;
import ph.txtdis.fx.dialog.LeaveDialog;
import ph.txtdis.fx.table.column.combo.LeaveTypeColumn;
import ph.txtdis.fx.table.column.date.LeaveStartColumn;
import ph.txtdis.fx.table.column.integer.LeaveDayCountColumn;

@Component
public class LeaveTable extends BoxedTable<Leave, LeaveDialog> {

    @Autowired
    private LeaveTypeColumn typeCol;

    @Autowired
    private LeaveStartColumn startCol;

    @Autowired
    private LeaveDayCountColumn dayCountCol;

    public LeaveTable() {
        super("Leave");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(typeCol, startCol, dayCountCol);
    }
}
