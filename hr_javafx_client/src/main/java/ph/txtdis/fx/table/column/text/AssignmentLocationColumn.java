package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Assignment;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class AssignmentLocationColumn extends TextColumn<Assignment> {

    public AssignmentLocationColumn() {
        super("Location", "location", 160);
    }
}
