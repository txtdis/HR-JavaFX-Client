package ph.txtdis.fx.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.stage.Stage;
import ph.txtdis.fx.dialog.UserDialog;

@Component
public class UserButton extends FontButton {

    @Autowired
    private UserDialog dialog;

    public UserButton() {
        super("\ue82d", "System User", 44);
    }

    public UserButton stage(Stage stage) {
        setOnAction(event -> dialog.stage(stage).showAndWait());
        return this;
    }
}
