package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Family;
import ph.txtdis.fx.combo.FamilyCombo;
import ph.txtdis.fx.datepicker.BirthdatePicker;
import ph.txtdis.fx.field.DesignationField;
import ph.txtdis.fx.field.GivenNameField;
import ph.txtdis.fx.field.InstitutionField;
import ph.txtdis.fx.field.SurnameField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
public class FamilyDialog extends FieldDialog<Family, HumanResourceService>
        implements Inputted<Family> {

    @Autowired
    private FamilyCombo familyCombo;

    @Autowired
    private SurnameField surnameField;

    @Autowired
    private GivenNameField givenNameField;

    @Autowired
    private BirthdatePicker birthdatePicker;

    @Autowired
    private InstitutionField institutionField;

    @Autowired
    private DesignationField designationField;

    public FamilyDialog() {
        super("Family");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(familyCombo, surnameField, givenNameField,
                birthdatePicker, institutionField, designationField);
    }

    @Override
    protected Family createEntity() {
        return new Family(familyCombo.getValue(), surnameField.getValue(),
                givenNameField.getValue(), birthdatePicker.getValue(),
                institutionField.getValue(), designationField.getValue());
    }
}
