package ph.txtdis.fx.button.large;

import org.springframework.stereotype.Component;

import javafx.stage.Stage;
import ph.txtdis.fx.button.LargeButton;

@Component
public class CloseButton extends LargeButton {

    public CloseButton() {
        this("Close");
    }

    public CloseButton(String name) {
        super(name);
    }

    public CloseButton close(Stage stage) {
        setOnAction(event -> stage.close());
        return this;
    }
}
