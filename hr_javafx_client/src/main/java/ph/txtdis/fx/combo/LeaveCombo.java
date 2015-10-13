package ph.txtdis.fx.combo;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledComboBox;
import ph.txtdis.type.LeaveType;

@Component
public class LeaveCombo extends LabeledComboBox<LeaveType> {

    public LeaveCombo() {
        super("Type", LeaveType.values());
    }
}
