package ph.txtdis.fx.input;

import com.sun.javafx.scene.control.behavior.TextFieldBehavior;
import com.sun.javafx.scene.control.skin.TextFieldSkin;

import javafx.beans.binding.BooleanBinding;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

@SuppressWarnings("restriction")
public abstract class InputField extends TextField {

    public InputField() {
        traversePressedEnterKey();
        setStyle("-fx-font-size: 11pt; ");
    }

    private void traversePressedEnterKey() {
        addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                TextFieldBehavior behavior = ((TextFieldSkin) getSkin())
                        .getBehavior();
                behavior.traverseNext();
            }
        });
    }

    public BooleanBinding isEmpty() {
        return textProperty().isEmpty();
    }
}
