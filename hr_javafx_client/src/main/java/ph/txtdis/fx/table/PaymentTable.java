package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Payment;
import ph.txtdis.fx.dialog.PaymentDialog;
import ph.txtdis.fx.table.column.currency.PaymentValueColumn;
import ph.txtdis.fx.table.column.date.PaymentDateColumn;

@Component
@SuppressWarnings("unused")
public class PaymentTable extends InputTable<Payment, PaymentDialog> {

    @Autowired
    private PaymentDateColumn paymentDateCol;

    @Autowired
    private PaymentValueColumn paymentValueCol;

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(new PaymentDateColumn(), new PaymentValueColumn());
    }

    @Override
    protected void append() {
        dialog = new PaymentDialog();
        super.append();
    }
}
