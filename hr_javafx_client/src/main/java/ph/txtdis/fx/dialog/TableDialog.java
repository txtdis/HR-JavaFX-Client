package ph.txtdis.fx.dialog;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ph.txtdis.fx.gridpane.Grid;

public abstract class TableDialog<S, DS, TV extends TableView<S>> extends
        InputDialog {

    @Autowired
    protected Grid grid;

    @Autowired
    protected DS service;

    @Autowired
    protected TV table;

    public TableDialog(String name) {
        super(name + " List");
    }

    @Override
    protected Node[] nodes() {
        grid.getChildren().clear();
        grid.add(table, 0, 0);
        return new Node[] { header(), grid, buttonBox() };
    }

    @Override
    protected Button[] buttons() {
        return new Button[] { closeButton() };
    }
}
