package ph.txtdis.fx.table.column.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.GovtId;
import ph.txtdis.fx.table.column.ComboColumn;
import ph.txtdis.type.GovtIdType;

@Component
public class GovtIdTypeColumn extends ComboColumn<GovtId, GovtIdType> {

    public GovtIdTypeColumn() {
        super("Type", "type", GovtIdType.values(), 160);
    }
}
