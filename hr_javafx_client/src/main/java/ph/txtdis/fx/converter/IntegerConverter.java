package ph.txtdis.fx.converter;

import javafx.util.StringConverter;
import ph.txtdis.util.Numeric;

public class IntegerConverter extends StringConverter<Integer> {

    @Override
    public String toString(Integer number) {
        return Numeric.formatInt(number);
    }

    @Override
    public Integer fromString(String text) {
        return Numeric.parseInteger(text);
    }
}
