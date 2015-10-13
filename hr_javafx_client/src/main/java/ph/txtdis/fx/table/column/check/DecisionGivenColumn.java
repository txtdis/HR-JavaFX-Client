package ph.txtdis.fx.table.column.check;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.table.column.CheckColumn;

@Component
public class DecisionGivenColumn extends CheckColumn<Discipline> {

    public DecisionGivenColumn() {
        super("Decision", "decisionGiven");
    }
}
