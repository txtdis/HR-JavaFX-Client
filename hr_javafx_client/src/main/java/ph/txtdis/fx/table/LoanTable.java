package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Loan;
import ph.txtdis.fx.dialog.LoanDialog;
import ph.txtdis.fx.table.column.PaymentColumn;
import ph.txtdis.fx.table.column.combo.LoanTypeColumn;
import ph.txtdis.fx.table.column.currency.LoanBalanceColumn;
import ph.txtdis.fx.table.column.currency.LoanValueColumn;
import ph.txtdis.fx.table.column.date.LoanStartColumn;

@Component
public class LoanTable extends BoxedTable<Loan, LoanDialog> {

    @Autowired
    private LoanTypeColumn typeCol;

    @Autowired
    private LoanStartColumn startCol;

    @Autowired
    private LoanValueColumn amountCol;

    @Autowired
    private PaymentColumn paymentCol;

    @Autowired
    private LoanBalanceColumn balanceCol;

    public LoanTable() {
        super("Loan");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {

        getColumns().setAll(typeCol, startCol, amountCol, paymentCol,
                balanceCol);
    }
}
