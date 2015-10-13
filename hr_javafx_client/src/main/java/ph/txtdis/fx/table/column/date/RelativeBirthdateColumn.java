package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Family;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class RelativeBirthdateColumn extends DateColumn<Family> {

    public RelativeBirthdateColumn() {
        super("Birthdate", "birthDate");
    }
}
