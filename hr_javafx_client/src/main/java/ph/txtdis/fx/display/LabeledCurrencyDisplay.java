package ph.txtdis.fx.display;

import java.math.BigDecimal;

import ph.txtdis.fx.input.DecimalField;
import ph.txtdis.fx.input.LabeledTextField;

public class LabeledCurrencyDisplay extends LabeledTextField<BigDecimal>{

	public LabeledCurrencyDisplay(String name) {
		super(name, new CurrencyDisplay());
	}

	@Override
    public BigDecimal getValue() {
        return ((DecimalField) textField).getValue();
    }

	@Override
    public void reset() {
        textField.setText("");
    }
}
