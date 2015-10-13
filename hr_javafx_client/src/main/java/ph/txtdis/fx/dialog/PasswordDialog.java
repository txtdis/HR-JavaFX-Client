package ph.txtdis.fx.dialog;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.Node;
import javafx.scene.control.Button;
import ph.txtdis.dto.User;
import ph.txtdis.exception.DifferentPasswordException;
import ph.txtdis.fx.button.large.ChangeButton;
import ph.txtdis.fx.gridpane.Grid;
import ph.txtdis.fx.input.PasswordInput;
import ph.txtdis.fx.label.PasswordInputLabel;
import ph.txtdis.fx.label.PasswordRetryLabel;
import ph.txtdis.service.UserService;
import ph.txtdis.util.Spring;

public abstract class PasswordDialog extends InputDialog {

    @Autowired
    protected UserService service;

    @Autowired
    private PasswordInputLabel label1;

    @Autowired
    private PasswordRetryLabel label2;

    @Autowired
    protected PasswordInput password1;

    @Autowired
    protected PasswordInput password2;

    @Autowired
    protected ChangeButton changeButton;

    @Autowired
    protected Grid grid;

    @Autowired
    private ErrorDialog error;

    public PasswordDialog(String name) {
        super(name);
    }

    @Override
    protected Node[] nodes() {
        grid.add(label1, 0, 1);
        grid.add(password1, 1, 1);
        grid.add(label2, 0, 2);
        grid.add(password2, 1, 2);
        return new Node[] { header(), grid, buttonBox() };
    }

    @Override
    protected void process() {
        try {
            comparePasswords();
            save();
        } catch (Exception e) {
            handleError(e);
        }
    }

    private void comparePasswords() throws Exception {
        if (!(password1().equals(password2())))
            throw new DifferentPasswordException();
    }

    private String password1() {
        return password1.getText();
    }

    private void handleError(Exception e) {
        error.message(e.getMessage()).stage(this).showAndWait();
        clearFields();
    }

    @Override
    protected Button[] buttons() {
        return new Button[] { changeButton(), closeButton() };
    }

    protected Button changeButton() {
        changeButton.setOnAction(event -> process());
        changeButton.disableIf(password2.isEmpty());
        return changeButton;
    }

    private void save() throws Exception {
        saveUser();
        Spring.setPassword(password2());
        close();
    }

    protected void saveUser() throws Exception {
        User user = Spring.user();
        user.setPassword(encodedPassword());
        service.save(user);
    }

    protected String encodedPassword() {
        return Spring.encode(password2());
    }

    protected String password2() {
        return password2.getText();
    }

    protected void clearFields() {
        password1.clear();
        password2.clear();
        password1.requestFocus();
    }

    @Override
    protected void setBindings() {
        password2.disableIf(password1.isEmpty());
        changeButton.disableIf(password2.isEmpty());
    }
}