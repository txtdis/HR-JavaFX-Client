package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Family;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class RelativeInstitutionColumn extends TextColumn<Family> {

    public RelativeInstitutionColumn() {
        super("Institution", "institution", 160);
    }
}
