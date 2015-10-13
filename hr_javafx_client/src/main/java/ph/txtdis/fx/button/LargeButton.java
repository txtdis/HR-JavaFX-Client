package ph.txtdis.fx.button;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public abstract class LargeButton extends AbstractButton {

    public LargeButton(String text) {
        super(text);
        setStyle("-fx-font-size: 14pt;");
        HBox.setMargin(this, new Insets(0, 0, 0, 10));
    }
}
