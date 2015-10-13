package ph.txtdis.fx.layout;

import org.springframework.stereotype.Component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

@Component
public class DialogButtonBox extends HBox {

    public DialogButtonBox() {
        setAlignment(Pos.CENTER_RIGHT);
        setPadding(new Insets(0, 0, 20, 0));
    }

    public DialogButtonBox addButtons(Button... buttons) {
        getChildren().setAll(buttons);
        return this;
    }
}
