package ph.txtdis.fx.table.column.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.EmployeeAddress;
import ph.txtdis.fx.table.column.ComboColumn;
import ph.txtdis.type.AddressType;

@Component
public class AddressTypeColumn extends
        ComboColumn<EmployeeAddress, AddressType> {

    public AddressTypeColumn() {
        super("Type", "type", AddressType.values(), 140);
    }
}
