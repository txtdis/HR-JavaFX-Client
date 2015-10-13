package ph.txtdis.fx.dialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ph.txtdis.exception.FailedAuthenticationException;
import ph.txtdis.exception.NoServerConnectionException;
import ph.txtdis.exception.StoppedServerException;
import ph.txtdis.fx.FontIcon;
import ph.txtdis.fx.button.LoginButton;
import ph.txtdis.fx.button.PasswordButton;
import ph.txtdis.fx.button.ServerButton;
import ph.txtdis.fx.input.PasswordInput;
import ph.txtdis.fx.input.StringField;
import ph.txtdis.fx.label.LoginUserLabel;
import ph.txtdis.fx.label.PasswordLabel;
import ph.txtdis.util.Login;
import ph.txtdis.util.Server;

@Component
public class LoginDialog extends Stage {

    @Autowired
    private Login login;

    @Autowired
    private Server server;

    @Autowired
    private LoginUserLabel userLabel;

    @Autowired
    private StringField userField;

    @Autowired
    private PasswordLabel passwordLabel;

    @Autowired
    private PasswordInput passwordField;

    @Autowired
    private ServerButton serverButton;

    @Autowired
    private ServerSelectionDialog serverDialog;

    @Autowired
    private PasswordButton passwordButton;

    @Autowired
    private ChangePasswordDialog passwordDialog;

    @Autowired
    private LoginButton loginButton;

    @Autowired
    private EmployeeMenu employeeMenu;

    @Autowired
    private ErrorDialog error;

    private static int tries;

    @Override
    public void showAndWait() {
        setIcon();
        setTitle();
        setScene();
        clearFields();
        userField.requestFocus();
        super.showAndWait();
    }

    public void setIcon() {
        Image icon = new FontIcon("\ue826", Color.NAVY);
        getIcons().add(icon);
    }

    private void setTitle() {
        setTitle("Welcome to txtDIS@" + server.name() + "!");
    }

    private void setScene() {
        initModality(Modality.APPLICATION_MODAL);
        setScene(new Scene(parentPane()));
    }

    private Parent parentPane() {
        HBox hb = new HBox(phoneInsideSpinningBallLogo(), inputBox());
        hb.setPadding(new Insets(30, 20, 30, 50));
        hb.setStyle(
                "-fx-border-color: -fx-base; -fx-background-color: #aaaaff; ");
        hb.setAlignment(Pos.CENTER);
        return hb;
    }

    private Node phoneInsideSpinningBallLogo() {
        return new StackPane(phoneLogo(), spinningBalls());
    }

    private Node phoneLogo() {
        Label p = new Label("\ue826");
        p.setStyle("-fx-font: 72 'txtdis'; -fx-text-fill: navy;");
        p.setPadding(new Insets(10));
        return p;
    }

    private Node spinningBalls() {
        ProgressIndicator pi = new ProgressIndicator(-1.0);
        pi.setStyle("-fx-accent: white; ");
        pi.setScaleX(2.0);
        pi.setScaleY(2.0);
        return pi;
    }

    private Node inputBox() {
        VBox vb = new VBox(gridPane(), buttons());
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(0, 0, 0, 50));
        return vb;
    }

    private Node gridPane() {
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(5);
        gp.setAlignment(Pos.CENTER);
        gp.add(userLabel, 0, 0);
        gp.add(userField, 1, 0);
        gp.add(passwordLabel, 0, 1);
        gp.add(passwordField, 1, 1);
        gp.setPadding(new Insets(0, 0, 10, 0));
        return gp;
    }

    private Node buttons() {
        setButtonsOnActionProperties();
        setButtonsDisableProperties();
        return new HBox(loginButton, passwordButton, serverButton);
    }

    private void setButtonsOnActionProperties() {
        setServerButtonOnClickedChangeLocationAction();
        passwordButton.setOnAction(
                event -> tryChangingPasswordUponVerification());
        loginButton.setOnAction(event -> tryLoggingInUponVerification());
    }

    private void setServerButtonOnClickedChangeLocationAction() {
        serverButton.setOnAction(event -> {
            serverDialog.stage(this).showAndWait();
            setTitle();
        });
    }

    private void setButtonsDisableProperties() {
        passwordField.disableProperty().bind(userField.isEmpty());
        loginButton.disableIf(passwordField.isEmpty());
        passwordButton.disableIf(passwordField.isEmpty());
    }

    private void tryChangingPasswordUponVerification() {
        try {
            changePasswordIfAuthenticated();
        } catch (NoServerConnectionException | StoppedServerException
                | FailedAuthenticationException e) {
            retryThrice(e.getMessage());
            e.printStackTrace();
        }
    }

    private void changePasswordIfAuthenticated()
            throws NoServerConnectionException, StoppedServerException,
            FailedAuthenticationException {
        validate();
        changePassword();
        clearFields();
    }

    private void changePassword() {
        passwordDialog.stage(this).showAndWait();
    }

    private void tryLoggingInUponVerification() {
        try {
            logInIfAuthenticated();
        } catch (NoServerConnectionException | StoppedServerException
                | FailedAuthenticationException e) {
            retryThrice(e.getMessage());
            e.printStackTrace();
        }
    }

    private void logInIfAuthenticated() throws NoServerConnectionException,
            StoppedServerException, FailedAuthenticationException {
        validate();
        close();
        employeeMenu.display();
    }

    private void retryThrice(String message) {
        error.message(message).stage(this).showAndWait();
        clearFields();
        if (++tries > 2)
            close();
    }

    private void validate() throws NoServerConnectionException,
            StoppedServerException, FailedAuthenticationException {
        login.validate(server.name(), userField.getText(), passwordField
                .getText());
    }

    private void clearFields() {
        userField.clear();
        passwordField.clear();
        userField.requestFocus();
    }
}
