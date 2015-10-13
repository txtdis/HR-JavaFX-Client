package ph.txtdis.fx.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.stage.Stage;
import ph.txtdis.fx.dialog.StyleDialog;

@Component
public class StyleButton extends FontButton {

    @Autowired
    private StyleDialog dialog;

    public StyleButton() {
        super("\ue825", "Theme", 44);
    }

    public StyleButton stage(Stage stage) {
        setOnAction(event -> dialog.stage(stage).showAndWait());
        return this;
    }
}
