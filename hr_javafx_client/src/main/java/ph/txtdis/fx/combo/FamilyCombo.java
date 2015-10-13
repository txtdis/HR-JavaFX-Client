package ph.txtdis.fx.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledComboBox;
import ph.txtdis.type.FamilyType;

@Component
public class FamilyCombo extends LabeledComboBox<FamilyType> {

    public FamilyCombo() {
        super("Type", FamilyType.values());
    }
}
