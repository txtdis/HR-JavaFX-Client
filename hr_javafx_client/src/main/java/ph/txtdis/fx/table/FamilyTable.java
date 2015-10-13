package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Family;
import ph.txtdis.fx.dialog.FamilyDialog;
import ph.txtdis.fx.table.column.combo.FamilyTypeColumn;
import ph.txtdis.fx.table.column.date.RelativeBirthdateColumn;
import ph.txtdis.fx.table.column.text.RelativeDesignationColumn;
import ph.txtdis.fx.table.column.text.RelativeInstitutionColumn;
import ph.txtdis.fx.table.column.text.RelativeNameColumn;
import ph.txtdis.fx.table.column.text.RelativeSurnameColumn;

@Component
public class FamilyTable extends InputTable<Family, FamilyDialog> {

    @Autowired
    private FamilyTypeColumn typeCol;

    @Autowired
    private RelativeSurnameColumn surnameCol;

    @Autowired
    private RelativeNameColumn nameCol;

    @Autowired
    private RelativeBirthdateColumn birthdateCol;

    @Autowired
    private RelativeInstitutionColumn institutionCol;

    @Autowired
    private RelativeDesignationColumn designationCol;

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(typeCol, surnameCol, nameCol, birthdateCol,
                institutionCol, designationCol);
    }
}
