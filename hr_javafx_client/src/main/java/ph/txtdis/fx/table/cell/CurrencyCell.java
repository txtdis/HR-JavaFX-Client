package ph.txtdis.fx.table.cell;

import java.math.BigDecimal;

import javafx.scene.control.cell.TextFieldTableCell;
import ph.txtdis.fx.Styled;
import ph.txtdis.fx.converter.CurrencyConverter;
import ph.txtdis.fx.input.StylableTextField;

public class CurrencyCell<S> extends TextFieldTableCell<S, BigDecimal>implements
        StylableTextField {

    public CurrencyCell() {
        super(new CurrencyConverter());
    }

    @Override
    public void updateItem(BigDecimal number, boolean empty) {
        super.updateItem(number, empty);
        if (number != null)
            Styled.forCurrency(this, number);
    }
}
