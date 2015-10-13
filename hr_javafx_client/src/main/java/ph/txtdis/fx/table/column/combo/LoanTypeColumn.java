package ph.txtdis.fx.table.column.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Loan;
import ph.txtdis.fx.table.column.ComboColumn;
import ph.txtdis.type.LoanType;

@Component
public class LoanTypeColumn extends ComboColumn<Loan, LoanType> {

    public LoanTypeColumn() {
        super("Type", "type", LoanType.values(), 140);
    }
}
