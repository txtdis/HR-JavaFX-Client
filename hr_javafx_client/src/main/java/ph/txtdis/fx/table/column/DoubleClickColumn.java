package ph.txtdis.fx.table.column;

import ph.txtdis.fx.table.cell.DoubleClickCell;

public abstract class DoubleClickColumn<S, T> extends AbstractColumn<S, T> {

    public DoubleClickColumn(String text, String field, int minWidth) {
        super(text, field, minWidth);
        setEditable(false);
    }

    @Override
    protected void setTableCells() {
        setCellFactory(c -> new DoubleClickCell<S, T>());
    }
}
