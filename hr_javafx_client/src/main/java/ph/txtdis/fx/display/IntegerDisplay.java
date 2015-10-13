package ph.txtdis.fx.display;

import javafx.scene.control.TextField;
import ph.txtdis.fx.Styled;
import ph.txtdis.fx.input.StylableTextField;
import ph.txtdis.util.Numeric;

public class IntegerDisplay extends TextField implements StylableTextField {

    public IntegerDisplay() {
        this.setEditable(false);
        this.focusTraversableProperty().set(false);
        setMaxWidth(80);
    }

    public IntegerDisplay(int value) {
        this();
        setValue(value);
    }

    public int getValue() {
        return Numeric.parseInteger(getText());
    }

    public void setValue(int value) {
        Styled.forInteger(this, value);
    }
}