package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class AllegationColumn extends TextColumn<Discipline> {

    public AllegationColumn() {
        super("Allegation", "allegation", 100);
    }
}
