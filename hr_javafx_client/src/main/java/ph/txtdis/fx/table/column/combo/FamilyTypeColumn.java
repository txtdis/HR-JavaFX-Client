package ph.txtdis.fx.table.column.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Family;
import ph.txtdis.fx.table.column.ComboColumn;
import ph.txtdis.type.FamilyType;

@Component
public class FamilyTypeColumn extends ComboColumn<Family, FamilyType> {

    public FamilyTypeColumn() {
        super("Relation", "type", FamilyType.values(), 120);
    }
}
