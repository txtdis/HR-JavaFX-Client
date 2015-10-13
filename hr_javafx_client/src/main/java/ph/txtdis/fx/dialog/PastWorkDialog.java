package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.datepicker.EndDatePicker;
import ph.txtdis.fx.datepicker.StartDatePicker;
import ph.txtdis.fx.field.DesignationField;
import ph.txtdis.fx.field.EmployerField;
import ph.txtdis.fx.field.LastPayField;
import ph.txtdis.fx.field.ReasonForLeavingField;
import ph.txtdis.fx.field.ReferenceDesignationField;
import ph.txtdis.fx.field.ReferenceNameField;
import ph.txtdis.fx.field.ReferencePhoneField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
public class PastWorkDialog extends FieldDialog<PastWork, HumanResourceService>
        implements Inputted<PastWork> {

    @Autowired
    private StartDatePicker startDatePicker;

    @Autowired
    private EndDatePicker endDatePicker;

    @Autowired
    private EmployerField employerField;

    @Autowired
    private DesignationField designationField;

    @Autowired
    private LastPayField lastPayField;

    @Autowired
    private ReasonForLeavingField reasonForLeavingField;

    @Autowired
    private ReferenceNameField referenceNameField;

    @Autowired
    private ReferenceDesignationField referenceDesignationField;

    @Autowired
    private ReferencePhoneField referencePhoneField;

    public PastWorkDialog() {
        super("Past Work");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        // @formatter:off
        return Arrays.asList(
                startDatePicker,
                endDatePicker,
                employerField,
                designationField,
                lastPayField,
                reasonForLeavingField,
                referenceNameField,
                referenceDesignationField,
                referencePhoneField);
        // @formatter:on
    }

    @Override
    protected PastWork createEntity() {
        // @formatter:off
        return new PastWork(
                startDatePicker.getValue(),
                endDatePicker.getValue(),
                employerField.getValue(),
                designationField.getValue(),
                lastPayField.getValue(),
                reasonForLeavingField.getValue(),
                referenceNameField.getValue(),
                referenceDesignationField.getValue(),
                referencePhoneField.getValue());
        // @formatter:on
    }
}
