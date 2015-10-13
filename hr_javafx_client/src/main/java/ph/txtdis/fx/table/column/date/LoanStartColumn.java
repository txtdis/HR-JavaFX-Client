package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Loan;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class LoanStartColumn extends DateColumn<Loan> {

    public LoanStartColumn() {
        super("Start", "startDate");
    }
}
