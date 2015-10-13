package ph.txtdis.fx.display;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import ph.txtdis.fx.input.LabeledTextField;
import ph.txtdis.fx.input.StringField;
import ph.txtdis.util.Numeric;
import ph.txtdis.util.Temporal;

public class LabeledDisplay extends LabeledTextField<String> {

    public LabeledDisplay(String name, int width) {
        super(name, new StringField(width));
        textField.setEditable(false);
        textField.focusTraversableProperty().set(false);
    }

    @Override
    public String getValue() {
        return textField.getText();
    }

    public void setDate(LocalDate date) {
        setText(Temporal.formatDate(date));
    }

    public void setDecimal(BigDecimal number) {
        setText(Numeric.formatDecimal(number));
    }

    public void setInt(Integer number) {
        setText(Numeric.formatInt(number));
    }

    public void setLong(Long number) {
        setText(Numeric.formatId(number));
    }

    public void setPhone(PhoneNumber number) {
        setText(Numeric.formatPhone(number));
    }

    public void setText(String value) {
        textField.setText(value);
    }
}
