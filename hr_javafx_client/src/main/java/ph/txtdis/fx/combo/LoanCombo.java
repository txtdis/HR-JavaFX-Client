package ph.txtdis.fx.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledComboBox;
import ph.txtdis.type.LoanType;

@Component
public class LoanCombo extends LabeledComboBox<LoanType> {

    public LoanCombo() {
        super("Type", LoanType.values());
    }
}
