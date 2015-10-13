package ph.txtdis.fx.table.column.doubleclick;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Employee;
import ph.txtdis.fx.table.column.DoubleClickColumn;

@Component
public class EmployeeIdDoubleClickColumn extends DoubleClickColumn<Employee, Long> {

	public EmployeeIdDoubleClickColumn() {
		super("ID", "id", 50);
	}
}
