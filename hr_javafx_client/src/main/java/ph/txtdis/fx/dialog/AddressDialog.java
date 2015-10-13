package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.EmployeeAddress;
import ph.txtdis.fx.combo.AddressCombo;
import ph.txtdis.fx.field.BarangayField;
import ph.txtdis.fx.field.ProvinceField;
import ph.txtdis.fx.field.StreetField;
import ph.txtdis.fx.field.TownField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
@Scope(value = "prototype")
public class AddressDialog extends
        FieldDialog<EmployeeAddress, HumanResourceService>implements
        Inputted<EmployeeAddress> {

    @Autowired
    private AddressCombo addressCombo;

    @Autowired
    private StreetField streetField;

    @Autowired
    private BarangayField barangayField;

    @Autowired
    private TownField townField;

    @Autowired
    private ProvinceField provinceField;

    public AddressDialog() {
        super("Address");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(addressCombo, streetField, barangayField,
                townField, provinceField);
    }

    @Override
    protected EmployeeAddress createEntity() {
        // @formatter:off
        String location
                = streetField.getValue() + ", "
                + barangayField.getValue() + ", "
                + townField.getValue() + ", "
                + provinceField.getValue();
        // @formatter:on
        return new EmployeeAddress(addressCombo.getValue(), location);
    }
}
