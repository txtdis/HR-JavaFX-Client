package ph.txtdis.fx.converter;

import java.math.BigDecimal;

import javafx.util.StringConverter;
import ph.txtdis.util.Numeric;

public class QtyConverter extends StringConverter<BigDecimal> {

    @Override
    public String toString(BigDecimal number) {
        return Numeric.formatQuantity(number);
    }

    @Override
    public BigDecimal fromString(String text) {
        return Numeric.parseBigDecimal(text);
    }
}
