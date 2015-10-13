package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Assignment;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class AssignmentDesignationColumn extends TextColumn<Assignment> {

    public AssignmentDesignationColumn() {
        super("Designation", "designation", 100);
    }
}
