package ph.txtdis.fx.table.cell;

import java.math.BigDecimal;

import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import ph.txtdis.fx.input.StylableTextField;
import ph.txtdis.util.Numeric;

public class FourPlaceCell<S> extends TextFieldTableCell<S, BigDecimal> implements StylableTextField {

    public FourPlaceCell() {
        super(new StringConverter<BigDecimal>() {

            @Override
            public String toString(BigDecimal number) {
                return Numeric.format4Place(number);
            }

            @Override
            public BigDecimal fromString(String text) {
                return Numeric.parseBigDecimal(text);
            }
        });
    }

    @Override
    public void updateItem(BigDecimal number, boolean empty) {
        super.updateItem(number, empty);
        if (!empty)
            Numeric.format4Place(number);
    }
}
