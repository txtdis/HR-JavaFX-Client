package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Loan;
import ph.txtdis.fx.combo.LoanCombo;
import ph.txtdis.fx.datepicker.StartDatePicker;
import ph.txtdis.fx.field.AmountField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
public class LoanDialog extends FieldDialog<Loan, HumanResourceService>
        implements Inputted<Loan> {

    @Autowired
    private LoanCombo loanCombo;

    @Autowired
    private StartDatePicker startDatePicker;

    @Autowired
    private AmountField amountField;

    public LoanDialog() {
        super("Loan");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(loanCombo, startDatePicker, amountField);
    }

    @Override
    protected Loan createEntity() {
        return new Loan(loanCombo.getValue(), startDatePicker.getValue(),
                amountField.getValue());
    }
}
