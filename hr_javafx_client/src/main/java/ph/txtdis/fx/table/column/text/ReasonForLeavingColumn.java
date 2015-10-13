package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class ReasonForLeavingColumn extends TextColumn<PastWork> {

    public ReasonForLeavingColumn() {
        super("Reason for\nLeaving", "reasonForLeaving", 120);
    }
}
