package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class IncidenceColumn extends DateColumn<Discipline> {

    public IncidenceColumn() {
        super("Incidence", "incidenceDate");
    }
}
