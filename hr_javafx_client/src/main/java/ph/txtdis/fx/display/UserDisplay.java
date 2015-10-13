package ph.txtdis.fx.display;

import javafx.scene.control.TextField;

public class UserDisplay extends TextField {

    public UserDisplay(String user) {
        setText(user);
        setMaxWidth(120);
        setEditable(false);
        focusTraversableProperty().set(false);
    }
}
