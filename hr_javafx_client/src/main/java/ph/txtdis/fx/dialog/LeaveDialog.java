package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Leave;
import ph.txtdis.fx.combo.LeaveCombo;
import ph.txtdis.fx.datepicker.StartDatePicker;
import ph.txtdis.fx.field.DayCountField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
public class LeaveDialog extends FieldDialog<Leave, HumanResourceService>
        implements Inputted<Leave> {

    @Autowired
    private LeaveCombo leaveCombo;

    @Autowired
    private StartDatePicker startDatePicker;

    @Autowired
    private DayCountField dayCountField;

    public LeaveDialog() {
        super("Leave");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(leaveCombo, startDatePicker, dayCountField);
    }

    @Override
    protected Leave createEntity() {
        return new Leave(leaveCombo.getValue(), startDatePicker.getValue(),
                dayCountField.getValue());
    }
}
