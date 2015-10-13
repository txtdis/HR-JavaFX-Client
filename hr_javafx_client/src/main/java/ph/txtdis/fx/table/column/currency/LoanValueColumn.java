package ph.txtdis.fx.table.column.currency;

import org.springframework.stereotype.Component;

import javafx.collections.ObservableList;
import ph.txtdis.dto.Loan;
import ph.txtdis.fx.table.column.CurrencyColumn;

@Component
public class LoanValueColumn extends CurrencyColumn<Loan> {

    public LoanValueColumn() {
        super("Amount", "loanValue");
    }

    @Override
    protected void setOnEditCommit(String field) {
        setOnEditCommit(event -> {
            Loan loan = event.getRowValue();
            loan.setLoanValue(event.getNewValue());
            ObservableList<Loan> loans = event.getTableView().getItems();
            int index = loans.indexOf(loan);
            loans.set(index, loan);
        });
    }
}
