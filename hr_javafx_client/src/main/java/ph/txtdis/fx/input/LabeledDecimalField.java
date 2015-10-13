package ph.txtdis.fx.input;

import java.math.BigDecimal;

import ph.txtdis.util.Numeric;

public class LabeledDecimalField extends LabeledTextField<BigDecimal>{

	public LabeledDecimalField(String name) {
		super(name, new DecimalField());
	}

	@Override
	public BigDecimal getValue() {
		return Numeric.parseBigDecimal(getText());
	}
	
	public DecimalField getDecimalField() {
	    return (DecimalField) textField;
	}
}
