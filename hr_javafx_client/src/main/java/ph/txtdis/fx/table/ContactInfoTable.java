package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.EmployeeContactInfo;
import ph.txtdis.fx.dialog.ContactInfoDialog;
import ph.txtdis.fx.table.column.combo.ContactTypeColumn;
import ph.txtdis.fx.table.column.text.ContactDetailColumn;

@Component
public class ContactInfoTable extends
        InputTable<EmployeeContactInfo, ContactInfoDialog> {

    @Autowired
    private ContactTypeColumn typeCol;

    @Autowired
    private ContactDetailColumn detailCol;

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(typeCol, detailCol);
        setMinHeight(65);
    }
}
