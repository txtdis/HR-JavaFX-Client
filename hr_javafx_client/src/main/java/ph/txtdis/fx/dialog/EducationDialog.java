package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Education;
import ph.txtdis.fx.datepicker.EndDatePicker;
import ph.txtdis.fx.datepicker.StartDatePicker;
import ph.txtdis.fx.field.HonorField;
import ph.txtdis.fx.field.InstitutionField;
import ph.txtdis.fx.field.ProgramField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
public class EducationDialog extends
        FieldDialog<Education, HumanResourceService>implements
        Inputted<Education> {

    @Autowired
    private StartDatePicker startDatePicker;

    @Autowired
    private EndDatePicker endDatePicker;

    @Autowired
    private InstitutionField institutionField;

    @Autowired
    private ProgramField programField;

    @Autowired
    private HonorField honorField;

    public EducationDialog() {
        super("Education");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(startDatePicker, endDatePicker, institutionField,
                programField, honorField);
    }

    @Override
    protected Education createEntity() {
        return new Education(startDatePicker.getValue(), endDatePicker
                .getValue(), institutionField.getValue(), programField
                        .getValue(), honorField.getValue());
    }
}
