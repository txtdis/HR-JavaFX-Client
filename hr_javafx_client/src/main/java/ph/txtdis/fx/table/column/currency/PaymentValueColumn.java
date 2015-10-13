package ph.txtdis.fx.table.column.currency;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Payment;
import ph.txtdis.fx.table.column.CurrencyColumn;

@Component
public class PaymentValueColumn extends CurrencyColumn<Payment> {

    public PaymentValueColumn() {
        super("Amount", "paymentValue");
    }
}
