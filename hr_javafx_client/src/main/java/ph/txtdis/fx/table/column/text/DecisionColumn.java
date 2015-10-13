package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class DecisionColumn extends TextColumn<Discipline> {

    public DecisionColumn() {
        super("Decision", "decision", 100);
    }
}
