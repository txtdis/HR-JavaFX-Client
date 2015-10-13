package ph.txtdis.fx.dialog;

import org.springframework.stereotype.Component;

@Component
public class ErrorDialog extends MessageDialog {

    public ErrorDialog() {
        super("\ue80f", "maroon");
    }
}
