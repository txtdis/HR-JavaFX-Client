package ph.txtdis.fx.button;

import org.springframework.stereotype.Component;

@Component
public class NewButton extends FontButton {

    public NewButton() {
        super("\ue800", "Add...");
    }
}
