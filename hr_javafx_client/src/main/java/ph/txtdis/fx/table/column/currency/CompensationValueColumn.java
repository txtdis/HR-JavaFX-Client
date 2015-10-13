package ph.txtdis.fx.table.column.currency;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Compensation;
import ph.txtdis.fx.table.column.CurrencyColumn;

@Component
public class CompensationValueColumn extends CurrencyColumn<Compensation> {

    public CompensationValueColumn() {
        super("Daily Rate", "dailyRateValue");
    }
}
