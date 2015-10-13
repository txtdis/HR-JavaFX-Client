package ph.txtdis.fx.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledComboBox;
import ph.txtdis.type.ContactInfoType;

@Component
public class ContactInfoCombo extends LabeledComboBox<ContactInfoType> {

    public ContactInfoCombo() {
        super("Type", ContactInfoType.values());
    }
}
