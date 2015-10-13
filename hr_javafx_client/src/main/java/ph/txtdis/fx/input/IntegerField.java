package ph.txtdis.fx.input;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import ph.txtdis.fx.Styled;
import ph.txtdis.util.Numeric;

public class IntegerField extends InputField implements StylableTextField {

    public IntegerField() {
        this(8.1);
    }

    public IntegerField(Integer integer) {
        this(8.0);
        setInt(integer);
    }

    public IntegerField(Long number) {
        this(11.1);
        setLong(number);
    }

    public IntegerField(double length) {

        textProperty().addListener(new ChangeListener<String>() {

            private StringProperty restrict = new SimpleStringProperty(
                    "[0-9-]");
            private boolean ignore;

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                if (ignore || newValue == null)
                    return;

                if (!newValue.matches(restrict.get() + "*") || ((length != 8.0
                        || newValue.length() > 1) && newValue.endsWith("-"))) {
                    ignore = true;
                    setText(oldValue);
                    ignore = false;
                } else if (newValue.length() > length) {
                    ignore = true;
                    setText(newValue.substring(0, (int) length));
                    ignore = false;
                } else {
                    setText(newValue);
                }
            }
        });

        setMaxWidth(length * 12);
        setPrefWidth(length * 12);
        setAlignment(Pos.TOP_RIGHT);
    }

    public int getInt() {
        return Numeric.parseInteger(getText());
    }

    public void setInt(Integer number) {
        Styled.forInteger(this, number);
    }

    public Long getLong() {
        return Numeric.parseLong(getText());
    }

    public void setLong(Long number) {
        setText(Numeric.formatId(number));
    }
}