package ph.txtdis.fx.table.column;

import java.math.BigDecimal;

import ph.txtdis.fx.table.cell.CurrencyCell;

public abstract class CurrencyColumn<S> extends AbstractColumn<S, BigDecimal> {

    public CurrencyColumn(String name, String valueSuffix) {
        super(name, valueSuffix, 100);
    }

    @Override
    protected void setTableCells() {
        setCellFactory(c -> new CurrencyCell<S>());
    }
}
