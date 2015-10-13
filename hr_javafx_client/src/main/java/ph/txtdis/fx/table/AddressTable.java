package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.EmployeeAddress;
import ph.txtdis.fx.dialog.AddressDialog;
import ph.txtdis.fx.table.column.combo.AddressTypeColumn;
import ph.txtdis.fx.table.column.text.EmployeeAddressColumn;

@Component
public class AddressTable extends InputTable<EmployeeAddress, AddressDialog> {

    @Autowired
    private AddressTypeColumn typeCol;

    @Autowired
    private EmployeeAddressColumn locationCol;

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(typeCol, locationCol);
        setMinHeight(65);
    }
}
