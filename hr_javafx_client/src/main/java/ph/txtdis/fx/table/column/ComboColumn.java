package ph.txtdis.fx.table.column;

import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.ComboBoxTableCell;

@Component
public abstract class ComboColumn<S, T> extends AbstractColumn<S, T> {

    private ObservableList<T> items;

    public ComboColumn(String name, String sSuffix, T[] items, int minWidth) {
        this(name, sSuffix, FXCollections.observableArrayList(items), minWidth);
    }

    public ComboColumn(String name, String sSuffix, ObservableList<T> items,
            int minWidth) {
        super(name, sSuffix, minWidth);
        this.items = items;
    }

    @Override
    protected void setTableCells() {
        setCellFactory(ComboBoxTableCell.forTableColumn(items));
    }
}
