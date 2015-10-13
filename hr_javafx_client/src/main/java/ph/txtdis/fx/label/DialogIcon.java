package ph.txtdis.fx.label;

import org.springframework.stereotype.Component;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

@Component
public class DialogIcon extends Label {

    public DialogIcon() {
        setPadding(new Insets(20, 0, 20, 0));
    }

    public DialogIcon graphic(String unicode) {
        setText(unicode);
        return this;
    }

    public DialogIcon color(String color) {
        setStyle("-fx-font: 90pt 'txtdis'; -fx-text-fill: " + color + ";");
        return this;
    }
}
