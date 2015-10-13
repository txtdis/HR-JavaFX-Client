package ph.txtdis.fx.dialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ph.txtdis.dto.Style;
import ph.txtdis.fx.StyleSheet;
import ph.txtdis.fx.txtDISicon;
import ph.txtdis.fx.button.BackupButton;
import ph.txtdis.fx.button.HRButton;
import ph.txtdis.fx.button.StyleButton;
import ph.txtdis.fx.button.UserButton;
import ph.txtdis.util.Spring;

@Component
public class EmployeeMenu extends Stage {

    @Autowired
    private BackupButton backupButton;

    @Autowired
    private HRButton hrButton;

    @Autowired
    private StyleButton styleButton;

    @Autowired
    private UserButton userButton;

    @Autowired
    private StyleSheet styleSheet;

    public void display() {
        HBox dialogBox = new HBox(gridPane());
        dialogBox.setPadding(new Insets(10));
        dialogBox.setAlignment(Pos.CENTER);

        getIcons().add(new txtDISicon());
        setScene(new Scene(dialogBox));
        setDefaultStyle();
        setTitle("txtDIS HR");
        show();
    }

    private GridPane gridPane() {
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(5);
        gp.setAlignment(Pos.CENTER);

        gp.add(hrButton, 0, 0);
        gp.add(userButton.stage(this), 1, 0);
        gp.add(styleButton.stage(this), 2, 0);
        gp.add(backupButton.stage(this), 3, 0);

        gp.add(getLabel("Employee"), 0, 1);
        gp.add(getLabel("Add User"), 1, 1);
        gp.add(getLabel("Change UI"), 2, 1);
        gp.add(getLabel("Backup"), 3, 1);
        return gp;
    }

    private Label getLabel(String name) {
        Label label = new Label(name);
        GridPane.setHalignment(label, HPos.CENTER);
        return label;
    }

    private void setDefaultStyle() {
        Style style = Spring.user().getStyle();
        if (style != null)
            styleSheet.update(style);
    }
}
