package ph.txtdis.fx.table.cell;

import javafx.scene.control.cell.TextFieldTableCell;
import ph.txtdis.fx.converter.PhoneConverter;
import ph.txtdis.fx.input.StylableTextField;
import ph.txtdis.util.Numeric;

public class PhoneCell<S> extends TextFieldTableCell<S, String>implements
        StylableTextField {

    public PhoneCell() {
        super(new PhoneConverter());
    }

    @Override
    public void updateItem(String phone, boolean empty) {
        super.updateItem(phone, empty);
        if (phone != null)
            Numeric.displayPhone(phone);
    }
}
