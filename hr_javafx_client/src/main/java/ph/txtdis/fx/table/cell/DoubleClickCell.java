package ph.txtdis.fx.table.cell;

import org.springframework.stereotype.Component;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import ph.txtdis.fx.FX;

@Component
public class DoubleClickCell<S, T> extends TextFieldTableCell<S, T> {

	protected TableRow<S> row;

	protected TableView<S> table;

	public DoubleClickCell() {
		setEditable(false);
		addEventFilter(MouseEvent.MOUSE_CLICKED, event -> onDoubleClick(event));
	}

	@Override
	public void updateItem(T item, boolean empty) {
		super.updateItem(item, empty);
		setText(item == null ? "" : getItem().toString());
		setTextProperties();
	}

	protected void next() {
		Node table = this.getParent();
		Node dialog = table.getParent();
		FX.stage(dialog).close();
	}

	private void onDoubleClick(MouseEvent event) {
		if (event.getClickCount() > 1) {
			setRow(event);
			setTable();
			setTableUserData();
			next();
		}
	}

	private void setTableUserData() {
		table.setUserData(row.getItem());
	}

	private void setTable() {
		table = row.getTableView();
	}

	@SuppressWarnings("unchecked")
	private void setRow(MouseEvent event) {
		TableCell<S, T> tableCell = (TableCell<S, T>) event.getSource();
		row = tableCell.getTableRow();
	}

	private void setTextProperties() {
		setAlignment(Pos.CENTER_RIGHT);
		if (getText().contains(">"))
			setStyle("-fx-text-fill: red");
	}
}
