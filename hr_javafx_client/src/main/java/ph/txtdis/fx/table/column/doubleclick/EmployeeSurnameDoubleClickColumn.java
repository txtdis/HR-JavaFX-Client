package ph.txtdis.fx.table.column.doubleclick;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Employee;
import ph.txtdis.fx.table.column.DoubleClickColumn;

@Component
public class EmployeeSurnameDoubleClickColumn extends
        DoubleClickColumn<Employee, String> {

    public EmployeeSurnameDoubleClickColumn() {
        super("Last Name", "surname", 180);
    }
}
