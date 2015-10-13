package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Assignment;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class AssignmentStartColumn extends DateColumn<Assignment> {

    public AssignmentStartColumn() {
        super("Start", "startDate");
    }
}
