package ph.txtdis.fx.table.column.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.EmployeeContactInfo;
import ph.txtdis.fx.table.column.ComboColumn;
import ph.txtdis.type.ContactInfoType;

@Component
public class ContactTypeColumn extends
        ComboColumn<EmployeeContactInfo, ContactInfoType> {

    public ContactTypeColumn() {
        super("Type", "type", ContactInfoType.values(), 100);
    }
}
