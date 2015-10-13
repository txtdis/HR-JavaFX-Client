package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Family;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class RelativeNameColumn extends TextColumn<Family> {

    public RelativeNameColumn() {
        super("Name", "name", 120);
    }
}
