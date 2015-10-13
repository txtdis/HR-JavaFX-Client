package ph.txtdis.fx.dialog;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import javafx.scene.Node;
import javafx.scene.control.Button;
import ph.txtdis.dto.Authority;
import ph.txtdis.dto.User;
import ph.txtdis.exception.DuplicateException;
import ph.txtdis.fx.input.StringField;
import ph.txtdis.fx.label.AddUsernameLabel;
import ph.txtdis.type.UserType;

@Component
public class UserDialog extends PasswordDialog {

    @Autowired
    private AddUsernameLabel usernameLabel;

    @Autowired
    private ErrorDialog error;

    private StringField userField;

    public UserDialog() {
        super("Add New User");
    }

    @Override
    public void showAndWait() {
        super.showAndWait();
        clearFields();
    }

    @Override
    protected Node[] nodes() {
        userField = new StringField();
        userField.setOnAction(event -> validate());
        grid.getChildren().clear();
        grid.add(usernameLabel, 0, 0);
        grid.add(userField, 1, 0);
        return super.nodes();
    }

    private void validate() {
        try {
            validateUserName(userField.getText());
        } catch (DuplicateException | ResourceAccessException e) {
            e.printStackTrace();
            error.message(e.getMessage()).stage(this).showAndWait();
            clearFields();
        }
    }

    private void validateUserName(String username) throws DuplicateException,
            ResourceAccessException {
        if (service.find(username) != null)
            throw new DuplicateException(username);
    }

    @Override
    protected void saveUser() throws Exception {
        service.save(newUser());
    }

    private User newUser() {
        User user = new User(username(), encodedPassword(), true);
        user.setRoles(Arrays.asList(new Authority(UserType.MANAGER)));
        return user;
    }

    private String username() {
        return userField.getText();
    }

    @Override
    protected void clearFields() {
        clearPasswordFields();
        userField.clear();
        userField.requestFocus();
    }

    private void clearPasswordFields() {
        password1.clear();
        password2.clear();
    }

    @Override
    protected void setBindings() {
        password1.disableIf(userField.isEmpty());
        super.setBindings();
    }

    @Override
    protected Button changeButton() {
        changeButton.setText("Save");
        return super.changeButton();
    }
}