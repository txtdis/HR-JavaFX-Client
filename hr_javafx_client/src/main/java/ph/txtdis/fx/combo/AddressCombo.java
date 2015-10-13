package ph.txtdis.fx.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledComboBox;
import ph.txtdis.type.AddressType;

@Component
public class AddressCombo extends LabeledComboBox<AddressType> {

    public AddressCombo() {
        super("Type", AddressType.values());
    }
}
