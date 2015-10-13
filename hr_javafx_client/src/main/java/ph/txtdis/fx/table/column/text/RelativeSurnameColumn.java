package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Family;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class RelativeSurnameColumn extends TextColumn<Family> {

    public RelativeSurnameColumn() {
        super("Surname", "surname", 100);
    }
}
