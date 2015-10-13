package ph.txtdis.fx.table.column;

import ph.txtdis.fx.table.cell.PhoneCell;

public abstract class PhoneColumn<S> extends AbstractColumn<S, String> {

    public PhoneColumn(String name, String phoneSuffix) {
        super(name, phoneSuffix, 120);
    }

    @Override
    protected void setTableCells() {
        setCellFactory(c -> new PhoneCell<S>());
    }
}
