package ph.txtdis.fx.table.cell;

import java.time.ZonedDateTime;

import javafx.scene.control.cell.TextFieldTableCell;
import ph.txtdis.fx.converter.DateTimeConverter;
import ph.txtdis.fx.input.StylableTextField;
import ph.txtdis.util.Temporal;

public class DateTimeCell<S> extends TextFieldTableCell<S, ZonedDateTime>
        implements StylableTextField {

    public DateTimeCell() {
        super(new DateTimeConverter());
    }

    @Override
    public void updateItem(ZonedDateTime dateTime, boolean empty) {
        super.updateItem(dateTime, empty);
        if (dateTime != null)
            Temporal.formatZonedDateTime(dateTime);
    }
}
