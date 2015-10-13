package ph.txtdis.fx.table.column;

import ph.txtdis.fx.table.cell.IntegerCell;

public abstract class IntegerColumn<S> extends AbstractColumn<S, Integer> {

    public IntegerColumn(String name, String countSuffix) {
        super(name, countSuffix, 80);
    }

    @Override
    protected void setTableCells() {
        setCellFactory(c -> new IntegerCell<S>());
    }
}
