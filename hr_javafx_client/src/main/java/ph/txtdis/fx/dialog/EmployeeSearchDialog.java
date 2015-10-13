package ph.txtdis.fx.dialog;

import org.springframework.stereotype.Component;

@Component
public class EmployeeSearchDialog extends SearchDialog {

    public EmployeeSearchDialog() {
        super("n Employee", "given or last name —\nnot both —");
    }
}
