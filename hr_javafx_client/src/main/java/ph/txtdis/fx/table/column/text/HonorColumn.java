package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Education;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class HonorColumn extends TextColumn<Education> {

    public HonorColumn() {
        super("Highest Honor", "highestHonor", 160);
    }
}
