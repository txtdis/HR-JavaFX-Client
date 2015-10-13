package ph.txtdis.fx.dialog;

import org.springframework.stereotype.Component;

import javafx.scene.Node;

@Component
public class ChangePasswordDialog extends PasswordDialog {

    public ChangePasswordDialog() {
        super("Change Password");
    }

    @Override
    protected Node[] nodes() {
        grid.getChildren().clear();
        return super.nodes();
    }
}