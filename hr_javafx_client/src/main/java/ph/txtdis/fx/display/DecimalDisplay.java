package ph.txtdis.fx.display;

import java.math.BigDecimal;

import javafx.scene.control.TextField;
import ph.txtdis.fx.Styled;
import ph.txtdis.fx.input.StylableTextField;
import ph.txtdis.util.Numeric;

public class DecimalDisplay extends TextField implements StylableTextField {

    public DecimalDisplay() {
        this.setEditable(false);
        this.focusTraversableProperty().set(false);
        setMaxWidth(80);
    }

    public DecimalDisplay(BigDecimal value) {
        this();
        setValue(value);
    }

    public BigDecimal getValue() {
        return Numeric.parseBigDecimal(getText());
    }

    public void setValue(BigDecimal value) {
        Styled.forDecimal(this, value);
    }
}