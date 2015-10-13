package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class ReferenceDesignationColumn extends TextColumn<PastWork> {

    public ReferenceDesignationColumn() {
        super("Designation", "referenceDesignation", 160);
    }
}
