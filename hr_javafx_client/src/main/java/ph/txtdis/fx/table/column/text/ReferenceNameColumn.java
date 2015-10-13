package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class ReferenceNameColumn extends TextColumn<PastWork> {

    public ReferenceNameColumn() {
        super("Name", "referenceName", 240);
    }
}
