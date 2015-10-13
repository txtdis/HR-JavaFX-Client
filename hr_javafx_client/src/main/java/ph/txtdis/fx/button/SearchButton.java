package ph.txtdis.fx.button;

import org.springframework.stereotype.Component;

@Component
public class SearchButton extends FontButton {

    public SearchButton() {
        super("\ue824", "Find...");
    }
}
