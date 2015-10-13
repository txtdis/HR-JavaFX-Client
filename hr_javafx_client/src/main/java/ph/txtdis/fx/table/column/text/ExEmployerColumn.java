package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class ExEmployerColumn extends TextColumn<PastWork> {

    public ExEmployerColumn() {
        super("Employer", "employer", 160);
    }
}
