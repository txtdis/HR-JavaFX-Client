package ph.txtdis.fx.table.cell;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.Styled;
import ph.txtdis.fx.converter.CurrencyConverter;
import ph.txtdis.fx.input.StylableTextField;

@Component
public class DoubleClickCurrencyCell<S> extends DoubleClickCell<S, BigDecimal>
        implements StylableTextField {

    public DoubleClickCurrencyCell() {
        setConverter(new CurrencyConverter());
    }

    @Override
    public void updateItem(BigDecimal number, boolean empty) {
        super.updateItem(number, empty);
        if (number != null)
            Styled.forCurrency(this, number);
    }
}
