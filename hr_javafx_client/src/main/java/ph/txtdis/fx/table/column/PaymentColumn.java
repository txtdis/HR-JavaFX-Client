package ph.txtdis.fx.table.column;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Loan;
import ph.txtdis.fx.table.cell.PaymentCell;

@Component
public class PaymentColumn extends CurrencyColumn<Loan> {

    public PaymentColumn() {
        super("Payment", "paymentValue");
    }

    @Override
    protected void setTableCells() {
        setCellFactory(c -> new PaymentCell());
    }
}
