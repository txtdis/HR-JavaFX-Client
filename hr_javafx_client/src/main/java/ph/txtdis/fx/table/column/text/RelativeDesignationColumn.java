package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Family;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class RelativeDesignationColumn extends TextColumn<Family> {

    public RelativeDesignationColumn() {
        super("Designation", "designation", 160);
    }
}
