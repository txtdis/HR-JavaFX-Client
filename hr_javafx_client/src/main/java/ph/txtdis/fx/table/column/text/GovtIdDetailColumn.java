package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.GovtId;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class GovtIdDetailColumn extends TextColumn<GovtId> {

    public GovtIdDetailColumn() {
        super("Detail", "detail", 130);
    }
}
