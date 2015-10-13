package ph.txtdis.fx.input;

import java.math.BigDecimal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import ph.txtdis.fx.Styled;
import ph.txtdis.util.Numeric;

public class DecimalField extends InputField implements StylableTextField {

    public DecimalField() {
        super();
        setMaxWidth(120);
        StringProperty restrict = new SimpleStringProperty("[0-9-.]");
        textProperty().addListener(new ChangeListener<String>() {
            private boolean ignore;

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                if (ignore || newValue == null)
                    return;

                if (!newValue.matches(restrict.get() + "*") || (oldValue
                        .contains(".") && newValue.endsWith(".")) || (newValue
                                .length() > 1 && newValue.endsWith("-"))) {
                    ignore = true;
                    setText(oldValue);
                    ignore = false;
                }
            }
        });
        setAlignment(Pos.CENTER_RIGHT);
    }

    public DecimalField(BigDecimal value) {
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