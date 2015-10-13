package ph.txtdis.fx.table.cell;

import javafx.scene.control.cell.TextFieldTableCell;

public class TextCell<S> extends TextFieldTableCell<S, String> {

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null)
            item.toUpperCase();
    }
}
