package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Compensation;
import ph.txtdis.fx.dialog.CompensationDialog;
import ph.txtdis.fx.table.column.currency.CompensationValueColumn;
import ph.txtdis.fx.table.column.date.CompensationStartColumn;

@Component
public class CompensationTable extends
        BoxedTable<Compensation, CompensationDialog> {

    @Autowired
    private CompensationStartColumn startCol;

    @Autowired
    private CompensationValueColumn dailyRateCol;

    public CompensationTable() {
        super("Compensation");
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(startCol, dailyRateCol);
    }
}
