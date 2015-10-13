package ph.txtdis.fx.table.cell;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Loan;
import ph.txtdis.fx.dialog.PaymentTableDialog;

@Component
public class PaymentCell extends
        TableDialogOnDoubleClickCurrencyCell<Loan, Loan, PaymentTableDialog> {

    @Override
    protected Loan update(Loan entity) {
        entity.setPayments(dialog.getItems());
        return entity;
    }

    @Override
    protected void createDialog(Loan source) {
        dialog = new PaymentTableDialog();
        dialog.stage(parent());
        dialog.setSource(source);
        dialog.showAndWait();
    }
}
