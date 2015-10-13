package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledCurrencyField;

@Component
public class DailyRateField extends LabeledCurrencyField {

    public DailyRateField() {
        super("Daily Rate");
    }
}
