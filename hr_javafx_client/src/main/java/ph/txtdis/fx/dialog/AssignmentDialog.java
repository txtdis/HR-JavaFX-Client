package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Assignment;
import ph.txtdis.fx.datepicker.StartDatePicker;
import ph.txtdis.fx.field.DesignationField;
import ph.txtdis.fx.field.LocationField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
public class AssignmentDialog extends
        FieldDialog<Assignment, HumanResourceService>implements
        Inputted<Assignment> {

    @Autowired
    private StartDatePicker startDatePicker;

    @Autowired
    private LocationField locationField;

    @Autowired
    private DesignationField designationField;

    public AssignmentDialog() {
        super("Assignment");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(startDatePicker, locationField, designationField);
    }

    @Override
    protected Assignment createEntity() {
        return new Assignment(startDatePicker.getValue(), locationField
                .getValue(), designationField.getValue());
    }
}
