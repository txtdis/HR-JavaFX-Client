package ph.txtdis.fx.table.column;

import javafx.scene.control.cell.TextFieldTableCell;
import ph.txtdis.fx.converter.UpperCaseConverter;

public abstract class TextColumn<S> extends AbstractColumn<S, String> {

    public TextColumn(String name, String text, int minWidth) {
        super(name, text, minWidth);
    }

    @Override
    protected void setTableCells() {
        setCellFactory(TextFieldTableCell.forTableColumn(
                new UpperCaseConverter()));
    }
}
