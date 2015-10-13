package ph.txtdis.fx.button;

import org.springframework.stereotype.Component;

@Component
public class BackButton extends FontButton {

    public BackButton() {
        super("\ue803", "Back...");
    }
}
