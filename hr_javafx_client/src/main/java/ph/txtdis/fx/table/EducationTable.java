package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Education;
import ph.txtdis.fx.dialog.EducationDialog;
import ph.txtdis.fx.table.column.date.EducationEndColumn;
import ph.txtdis.fx.table.column.date.EducationStartColumn;
import ph.txtdis.fx.table.column.text.HonorColumn;
import ph.txtdis.fx.table.column.text.EmployeeInstitutionColumn;
import ph.txtdis.fx.table.column.text.ProgramColumn;

@Component
public class EducationTable extends InputTable<Education, EducationDialog> {

    @Autowired
    private EducationStartColumn startCol;

    @Autowired
    private EducationEndColumn endCol;

    @Autowired
    private EmployeeInstitutionColumn institutionCol;

    @Autowired
    private ProgramColumn programCol;

    @Autowired
    private HonorColumn honorCol;

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(startCol, endCol, institutionCol, programCol,
                honorCol);
    }
}
