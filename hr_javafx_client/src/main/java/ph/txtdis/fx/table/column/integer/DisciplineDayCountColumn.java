package ph.txtdis.fx.table.column.integer;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.table.column.IntegerColumn;

@Component
public class DisciplineDayCountColumn extends IntegerColumn<Discipline> {

    public DisciplineDayCountColumn() {
        super("No. of Days", "dayCount");
    }
}
