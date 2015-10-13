package ph.txtdis.fx.dialog;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.Node;
import javafx.scene.control.Button;
import ph.txtdis.fx.button.large.OpenButton;
import ph.txtdis.fx.gridpane.Grid;
import ph.txtdis.fx.input.IdNoField;
import ph.txtdis.fx.label.IdNoLabel;

public abstract class OpenByNoDialog extends InputDialog {

    @Autowired
    private Grid grid;

    @Autowired
    private OpenButton openButton;

    @Autowired
    private IdNoLabel idLabel;

    @Autowired
    private IdNoField idField;

    private Long id;

    public OpenByNoDialog(String name) {
        super(name + " Data Retrieval");
    }

    @Override
    protected Node[] nodes() {
        grid.getChildren().clear();
        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);
        return new Node[] { header(), grid, buttonBox() };
    }

    @Override
    protected Button[] buttons() {
        return new Button[] { openButton(), closeButton() };
    }

    private Button openButton() {
        openButton.setOnAction(event -> {
            id = idField.getIdNo();
            close();
        });
        openButton.disableIf(idField.isEmpty());
        return openButton;
    }

    public Long getId() {
        return id;
    }
}
