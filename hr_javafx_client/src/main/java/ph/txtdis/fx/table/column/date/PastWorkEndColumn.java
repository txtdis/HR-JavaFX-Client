package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class PastWorkEndColumn extends DateColumn<PastWork> {

    public PastWorkEndColumn() {
        super("End", "endDate");
    }
}
