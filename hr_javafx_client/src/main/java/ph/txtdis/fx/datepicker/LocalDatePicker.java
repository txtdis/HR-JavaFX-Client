package ph.txtdis.fx.datepicker;

import java.time.LocalDate;

import com.sun.javafx.scene.control.behavior.TextFieldBehavior;
import com.sun.javafx.scene.control.skin.TextFieldSkin;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

@SuppressWarnings("restriction")
public class LocalDatePicker extends DatePicker {

    public LocalDatePicker() {
        this(null);
    }

    public LocalDatePicker(LocalDate localDate) {
        super(localDate);
        traverseOnPressedEnterKey();
        setPromptText("mm/dd/yyyy");
    }

    private void traverseOnPressedEnterKey() {
        addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                TextField textField = getEditor();
                TextFieldBehavior behavior = ((TextFieldSkin) textField
                        .getSkin()).getBehavior();
                behavior.traverseNext();
            }
        });
    }

}
