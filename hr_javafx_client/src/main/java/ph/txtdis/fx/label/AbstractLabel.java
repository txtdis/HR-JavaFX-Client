package ph.txtdis.fx.label;

import javafx.scene.control.Label;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractLabel extends Label {

    public AbstractLabel(String text) {
        super(text);
        setStyle("-fx-font-size: 11pt; ");
    }
}
