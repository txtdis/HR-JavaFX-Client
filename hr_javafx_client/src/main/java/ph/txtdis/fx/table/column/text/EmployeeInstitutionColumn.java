package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Education;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class EmployeeInstitutionColumn extends TextColumn<Education> {

    public EmployeeInstitutionColumn() {
        super("Institution", "institution", 160);
    }
}
