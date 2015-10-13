package ph.txtdis.fx.table.column;

import java.time.LocalDate;

import ph.txtdis.fx.table.cell.DatePickerCell;

public abstract class DateColumn<S> extends AbstractColumn<S, LocalDate> {

    public DateColumn(String name, String dateSuffix) {
        super(name, dateSuffix, 120);
    }

    @Override
    protected void setTableCells() {
        setCellFactory(c -> new DatePickerCell<S>());
    }
}
