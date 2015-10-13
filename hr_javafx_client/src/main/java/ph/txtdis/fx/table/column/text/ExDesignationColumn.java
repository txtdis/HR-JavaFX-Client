package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class ExDesignationColumn extends TextColumn<PastWork> {

    public ExDesignationColumn() {
        super("Designation", "designation", 240);
    }
}
