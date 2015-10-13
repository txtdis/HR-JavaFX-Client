package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.EmployeeAddress;
import ph.txtdis.fx.table.column.TextColumn;

@Component
public class EmployeeAddressColumn extends TextColumn<EmployeeAddress> {

    public EmployeeAddressColumn() {
        super("Location", "location", 400);
    }
}
