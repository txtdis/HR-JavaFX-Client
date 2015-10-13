package ph.txtdis.fx.colorpicker;

import org.springframework.stereotype.Component;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

@Component
public class BackgroundColorPicker extends ColorPicker {

    public BackgroundColorPicker() {
        super(Color.LIGHTSTEELBLUE);
    }
}
