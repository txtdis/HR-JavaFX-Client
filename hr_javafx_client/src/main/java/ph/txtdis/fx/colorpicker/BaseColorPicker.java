package ph.txtdis.fx.colorpicker;

import org.springframework.stereotype.Component;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

@Component
public class BaseColorPicker extends ColorPicker {

    public BaseColorPicker() {
        super(Color.NAVY);
    }
}
