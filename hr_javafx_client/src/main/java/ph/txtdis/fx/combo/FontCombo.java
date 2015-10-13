package ph.txtdis.fx.combo;

import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;

@Component
public class FontCombo extends ComboBox<String> {

    public FontCombo() {
        super(FXCollections.observableList(Font.getFamilies()));
        getSelectionModel().select(defaultFont());
    }

    private String defaultFont() {
        return Font.getDefault().getFamily();
    }

}
