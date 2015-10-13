package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Payment;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class PaymentDateColumn extends DateColumn<Payment> {

    public PaymentDateColumn() {
        super("Payment", "paymentDate");
    }
}
