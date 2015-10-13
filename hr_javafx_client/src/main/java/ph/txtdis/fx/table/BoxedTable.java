package ph.txtdis.fx.table;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ph.txtdis.fx.dialog.Inputted;

public abstract class BoxedTable<T, D extends Inputted<T>> extends
        InputTable<T, D> {

    protected String name;

    public BoxedTable(String name) {
        this.name = name;
    }

    public VBox getBox() {
        return new VBox(label(), this.get());
    }

    private Node label() {
        Label label = new Label(name);
        label.setStyle("-fx-font-size: 16pt;");
        return label;
    }
}
