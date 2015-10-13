package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import ph.txtdis.fx.dialog.Inputted;
import ph.txtdis.fx.dialog.Owned;

public abstract class InputTable<T, D extends Inputted<T>> extends
        TableView<T> {

    @Autowired
    protected D dialog;

    private void addProperties() {
        setEditable(true);
        setContextMenu(createTableMenu());
        setRowFactory(table -> createRow(table));
    }

    private TableRow<T> createRow(TableView<T> table) {
        // @formatter:off
        TableRow<T> row = new TableRow<>();
        row.contextMenuProperty().bind(Bindings
                .when(row.itemProperty().isNotNull())
                .then(createRowMenu(table, row))
                .otherwise((ContextMenu) null));
        return row;
        // @formatter:on
    }

    private ContextMenu createTableMenu() {
        ContextMenu menu = new ContextMenu();
        menu.getItems().add(createAppendMenuItem());
        return menu;
    }

    private MenuItem createAppendMenuItem() {
        MenuItem item = new MenuItem("Append");
        item.setOnAction(event -> append());
        return item;
    }

    protected void append() {
        Stage stage = (Stage) getScene().getWindow();
        ((Owned) dialog).stage(stage);
        dialog.showAndWait();
        getItems().addAll(dialog.getAddedItems());
        scrollTo(getItems().size() - 1);
    }

    private ContextMenu createRowMenu(TableView<T> table, TableRow<T> row) {
        ContextMenu rowMenu = new ContextMenu();
        addTableMenuItemsToRowMenu(table, rowMenu);
        rowMenu.getItems().add(createDeleteRowMenuItem(row));
        return rowMenu;
    }

    private MenuItem createDeleteRowMenuItem(TableRow<T> row) {
        MenuItem item = new MenuItem("Delete row");
        item.setOnAction(event -> getItems().remove(row.getItem()));
        return item;
    }

    private void addTableMenuItemsToRowMenu(TableView<T> table,
            ContextMenu rowMenu) {
        table.getContextMenu().getItems().forEach(tableItem -> {
            MenuItem rowItem = new MenuItem(tableItem.getText());
            rowItem.setGraphic(tableItem.getGraphic());
            rowItem.setOnAction(tableItem.getOnAction());
            rowMenu.getItems().add(rowItem);
        });
    }

    protected abstract void addColumns();

    public InputTable<T, D> get() {
        addColumns();
        addProperties();
        return this;
    }
}
