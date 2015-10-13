package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.EmployeeContactInfo;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class ContactDetailColumn extends TextColumn<EmployeeContactInfo> {

    public ContactDetailColumn() {
        super("Detail", "detail", 200);
    }
}
