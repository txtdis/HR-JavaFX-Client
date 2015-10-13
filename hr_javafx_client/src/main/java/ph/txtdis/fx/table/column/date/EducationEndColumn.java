package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Education;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class EducationEndColumn extends DateColumn<Education> {

    public EducationEndColumn() {
        super("End", "endDate");
    }
}
