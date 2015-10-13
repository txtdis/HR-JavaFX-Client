package ph.txtdis.fx.table.column.doubleclick;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Employee;
import ph.txtdis.fx.table.column.DoubleClickColumn;

@Component
public class EmployeeNameDoubleClickColumn extends
        DoubleClickColumn<Employee, String> {

    public EmployeeNameDoubleClickColumn() {
        super("Given Name/s", "name", 240);
    }
}
