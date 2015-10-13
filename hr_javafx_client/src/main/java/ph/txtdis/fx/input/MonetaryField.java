package ph.txtdis.fx.input;

import java.math.BigDecimal;

import ph.txtdis.fx.Styled;

public class MonetaryField extends DecimalField {

    public MonetaryField() {
        super();
    }

    public MonetaryField(BigDecimal value) {
        super(value);
    }

    @Override
    public void setValue(BigDecimal number) {
        Styled.forCurrency(this, number);
    }
}
