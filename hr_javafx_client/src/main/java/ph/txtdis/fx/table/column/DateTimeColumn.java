package ph.txtdis.fx.table.column;

import java.time.ZonedDateTime;

public abstract class DateTimeColumn<S> extends
        AbstractColumn<S, ZonedDateTime> {

    public DateTimeColumn(String name, String onSuffix) {
        super(name, onSuffix, 160);
    }
}
