package ph.txtdis.fx.dialog;

import org.springframework.stereotype.Component;

import javafx.scene.Node;
import ph.txtdis.dto.Employee;
import ph.txtdis.fx.table.EmployeeTable;
import ph.txtdis.service.HumanResourceService;

@Component
public class FoundEmployeeDialog extends
        TableDialog<Employee, HumanResourceService, EmployeeTable> {

    public FoundEmployeeDialog() {
        super("Employee");
    }

    @Override
    protected Node[] nodes() {
        table.get();
        return super.nodes();
    }

    @Override
    public void showAndWait() {
        table.setItems(service.getSearchResult());
        super.showAndWait();
    }

    public Employee getSelectedItem() {
        Employee e = (Employee) table.getUserData();
        return e == null ? null : e;
    }
}
