
package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.EmployeeContactInfo;
import ph.txtdis.fx.combo.ContactInfoCombo;
import ph.txtdis.fx.field.DetailField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
@Scope(value = "prototype")
public class ContactInfoDialog extends
        FieldDialog<EmployeeContactInfo, HumanResourceService>implements
        Inputted<EmployeeContactInfo> {

    @Autowired
    private ContactInfoCombo contactInfoCombo;

    @Autowired
    private DetailField detailField;

    public ContactInfoDialog() {
        super("Contact Info");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(contactInfoCombo, detailField);
    }

    @Override
    protected EmployeeContactInfo createEntity() {
        return new EmployeeContactInfo(contactInfoCombo.getValue(), detailField
                .getValue());
    }
}
