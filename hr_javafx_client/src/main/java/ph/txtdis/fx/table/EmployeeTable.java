package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.control.TableView;
import ph.txtdis.dto.Employee;
import ph.txtdis.fx.table.column.doubleclick.EmployeeIdDoubleClickColumn;
import ph.txtdis.fx.table.column.doubleclick.EmployeeNameDoubleClickColumn;
import ph.txtdis.fx.table.column.doubleclick.EmployeeSurnameDoubleClickColumn;

@Component
public class EmployeeTable extends TableView<Employee> {

    @Autowired
    private EmployeeIdDoubleClickColumn idCol;

    @Autowired
    private EmployeeSurnameDoubleClickColumn surnameCol;

    @Autowired
    private EmployeeNameDoubleClickColumn nameCol;

    public Employee getSelectedItem() {
        return (Employee) getUserData();
    }

    @SuppressWarnings("unchecked")
    public EmployeeTable get() {
        getColumns().setAll(idCol, surnameCol, nameCol);
        return this;
    }
}
