package ph.txtdis.fx.table.column.currency;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Loan;
import ph.txtdis.fx.table.column.CurrencyColumn;

@Component
public class LoanBalanceColumn extends CurrencyColumn<Loan> {

    public LoanBalanceColumn() {
        super("Balance", "balanceValue");
        setEditable(false);
    }
}
