package ph.txtdis.fx.display;

import java.math.BigDecimal;

import ph.txtdis.fx.Styled;
import ph.txtdis.fx.input.InputField;
import ph.txtdis.fx.input.StylableTextField;
import ph.txtdis.util.Numeric;

public class CurrencyDisplay extends InputField implements StylableTextField {

    public CurrencyDisplay() {
        this.setEditable(false);
        this.focusTraversableProperty().set(false);
        setMaxWidth(100);
    }

    public CurrencyDisplay(BigDecimal value) {
        this();
        setValue(value);
    }

    public BigDecimal getValue() {
        return Numeric.parseBigDecimal(getText());
    }

    public void setValue(BigDecimal value) {
        Styled.forCurrency(this, value);
    }
}