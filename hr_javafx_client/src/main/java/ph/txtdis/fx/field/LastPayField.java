package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledCurrencyField;

@Component
public class LastPayField extends LabeledCurrencyField {

    public LastPayField() {
        super("Last Pay");
    }
}
