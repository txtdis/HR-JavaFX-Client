package ph.txtdis.fx.table.cell;

import java.math.BigDecimal;

import javafx.scene.control.cell.TextFieldTableCell;
import ph.txtdis.fx.Styled;
import ph.txtdis.fx.converter.QtyConverter;
import ph.txtdis.fx.input.StylableTextField;

public class QtyCell<S> extends TextFieldTableCell<S, BigDecimal>implements
        StylableTextField {

    public QtyCell() {
        super(new QtyConverter());
    }

    @Override
    public void updateItem(BigDecimal number, boolean empty) {
        super.updateItem(number, empty);
        if (!empty)
            Styled.forQuantity(this, number);
    }
}
