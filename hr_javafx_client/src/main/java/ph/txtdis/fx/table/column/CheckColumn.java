package ph.txtdis.fx.table.column;

import org.springframework.util.StringUtils;

import ph.txtdis.fx.table.cell.BooleanCell;
import ph.txtdis.util.Reflection;

public abstract class CheckColumn<S> extends AbstractColumn<S, Boolean> {

    private String field;

    public CheckColumn(String name, String field) {
        super(name, field, 80);
        this.field = field;
    }

    @Override
    protected void setTableCells() {
        setCellFactory(c -> {
            return new BooleanCell<S>() {
                @Override
                protected void setBoolean(S item, Boolean bool) {
                    // @formatter:off
                    Reflection.invokeOneParameterMethod(
                            item,
                            "set" + StringUtils.capitalize(field),
                            bool,
                            boolean.class);
                    // @formatter:on
                }
            };
        });
    }
}
