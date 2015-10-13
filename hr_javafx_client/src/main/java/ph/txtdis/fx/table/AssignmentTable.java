package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Assignment;
import ph.txtdis.fx.dialog.AssignmentDialog;
import ph.txtdis.fx.table.column.date.AssignmentEndColumn;
import ph.txtdis.fx.table.column.date.AssignmentStartColumn;
import ph.txtdis.fx.table.column.text.AssignmentDesignationColumn;
import ph.txtdis.fx.table.column.text.AssignmentLocationColumn;

@Component
public class AssignmentTable extends BoxedTable<Assignment, AssignmentDialog> {

    @Autowired
    private AssignmentStartColumn startCol;

    @Autowired
    private AssignmentEndColumn endCol;

    @Autowired
    private AssignmentLocationColumn locationCol;

    @Autowired
    private AssignmentDesignationColumn designationCol;

    public AssignmentTable() {
        super("Assignment");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(startCol, endCol, locationCol, designationCol);
    }
}
