package ph.txtdis.fx.table.column.date;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Education;
import ph.txtdis.fx.table.column.DateColumn;

@Component
public class EducationStartColumn extends DateColumn<Education> {

    public EducationStartColumn() {
        super("Start", "startDate");
    }
}
