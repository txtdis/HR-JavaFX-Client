package ph.txtdis.fx.table.cell;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.stage.Stage;
import ph.txtdis.fx.dialog.Sourced;

public abstract class TableDialogOnDoubleClickCurrencyCell<S, DS, D extends Sourced<DS>>
        extends DoubleClickCurrencyCell<S> {

    @Autowired
    protected D dialog;

    @Override
    protected void next() {
        S entity = row.getItem();
        createDialog(entity);
        table.getItems().set(row.getIndex(), update(entity));
    }

    protected Stage parent() {
        return (Stage) getScene().getWindow();
    }

    protected abstract S update(S entity);

    protected abstract void createDialog(S source);
}
