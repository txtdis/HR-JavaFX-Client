package ph.txtdis.fx.input;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import ph.txtdis.util.Numeric;

public class PhoneField extends InputField implements StylableTextField {

    public PhoneField() {
        this(13.1);
    }

    public PhoneField(String number) {
        this(13.1);
        setPhone(number);
    }

    public PhoneField(double length) {

        setPromptText("INCLUDE AREA CODE");

        textProperty().addListener(new ChangeListener<String>() {

            private StringProperty restrict = new SimpleStringProperty(
                    "[0-9 ]");
            private boolean ignore;

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                if (ignore || newValue == null)
                    return;

                if (!newValue.matches(restrict.get() + "*") || (newValue
                        .length() > 1 && newValue.endsWith("-"))) {
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

    public String getPhone() {
        return Numeric.persistPhone(getText());
    }

    public void setPhone(String number) {
        setText(Numeric.displayPhone(number));
    }
}