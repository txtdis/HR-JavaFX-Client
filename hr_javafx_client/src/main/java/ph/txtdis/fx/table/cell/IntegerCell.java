package ph.txtdis.fx.table.cell;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.TextFieldTableCell;
import ph.txtdis.fx.Styled;
import ph.txtdis.fx.converter.IntegerConverter;
import ph.txtdis.fx.input.StylableTextField;

public class IntegerCell<S> extends TextFieldTableCell<S, Integer>implements
        StylableTextField {

    public IntegerCell() {
        super(new IntegerConverter());
        allowSignedIntegersOnly();
    }

    private void allowSignedIntegersOnly() {
        textProperty().addListener(new ChangeListener<String>() {
            private boolean ignore;
            private StringProperty restrict = new SimpleStringProperty(
                    "[0-9-]");

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                if (ignore || newValue == null)
                    return;
                if (!newValue.matches(restrict.get() + "*") || ((newValue
                        .length() > 1) && newValue.endsWith("-"))) {
                    ignore = true;
                    setText(oldValue);
                    ignore = false;
                } else if (newValue.length() > 8) {
                    ignore = true;
                    setText(newValue.substring(0, 8));
                    ignore = false;
                } else {
                    setText(newValue);
                }
            }
        });
    }

    @Override
    public void updateItem(Integer number, boolean empty) {
        super.updateItem(number, empty);
        if (!empty)
            Styled.forInteger(this, number);
    }

}
