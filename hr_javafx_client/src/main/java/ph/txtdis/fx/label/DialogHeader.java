package ph.txtdis.fx.label;

import org.springframework.stereotype.Component;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class DialogHeader extends Label {

    public Label name(String text) {
        setText(text);
        setStyle("-fx-font-size: 26pt;");
        setPadding(new Insets(20, 0, 0, 0));
        return this;
    }
}
