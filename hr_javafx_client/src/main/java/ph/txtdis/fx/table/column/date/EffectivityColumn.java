package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class EffectivityColumn extends DateColumn<Discipline> {

    public EffectivityColumn() {
        super("Effectivity", "effectivityDate");
    }
}
