package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Education;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class ProgramColumn extends TextColumn<Education> {

    public ProgramColumn() {
        super("Program/Course", "program", 160);
    }
}
