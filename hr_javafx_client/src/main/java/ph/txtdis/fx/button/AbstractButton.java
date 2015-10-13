package ph.txtdis.fx.button;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public abstract class AbstractButton extends Button {

    public AbstractButton(String text) {
        super(text);
        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER)
                fire();
        });
    }

    public void disableIf(ObservableValue<? extends Boolean> observable) {
        disableProperty().bind(observable);
    }

    public Button get() {
        return this;
    }
}
