package ph.txtdis.fx.table.column.currency;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.CurrencyColumn;

@Component
public class LastPayColumn extends CurrencyColumn<PastWork> {

    public LastPayColumn() {
        super("Last Pay", "lastPayValue");
    }
}
