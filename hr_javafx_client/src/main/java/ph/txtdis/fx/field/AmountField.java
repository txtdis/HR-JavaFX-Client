package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledCurrencyField;

@Component
public class AmountField extends LabeledCurrencyField {

    public AmountField() {
        super("Amount");
    }
}
