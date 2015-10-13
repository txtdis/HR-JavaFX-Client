package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.GovtId;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class ExpiryColumn extends DateColumn<GovtId> {

    public ExpiryColumn() {
        super("Expiry", "expiryDate");
    }
}
