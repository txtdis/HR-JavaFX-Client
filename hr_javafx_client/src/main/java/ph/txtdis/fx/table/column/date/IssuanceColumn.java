package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.GovtId;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class IssuanceColumn extends DateColumn<GovtId> {

    public IssuanceColumn() {
        super("Issuance", "issuanceDate");
    }
}
