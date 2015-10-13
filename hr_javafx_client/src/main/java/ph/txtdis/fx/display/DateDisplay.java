package ph.txtdis.fx.display;

import java.time.LocalDate;

import javafx.scene.control.TextField;
import ph.txtdis.util.Temporal;

public class DateDisplay extends TextField {

    public DateDisplay(LocalDate date) {
        setDate(date);
        setMaxWidth(100);
        setEditable(false);
        focusTraversableProperty().set(false);
    }

    public void setDate(LocalDate date) {
        setText(date == null ? "" : Temporal.formatDate(date));
    }
}
