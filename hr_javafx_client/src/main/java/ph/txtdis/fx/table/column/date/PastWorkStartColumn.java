package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class PastWorkStartColumn extends DateColumn<PastWork> {

    public PastWorkStartColumn() {
        super("Start", "startDate");
    }
}
