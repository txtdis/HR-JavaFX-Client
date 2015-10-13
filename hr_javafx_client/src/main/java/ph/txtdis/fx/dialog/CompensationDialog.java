package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Compensation;
import ph.txtdis.fx.datepicker.StartDatePicker;
import ph.txtdis.fx.field.DailyRateField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
public class CompensationDialog extends
        FieldDialog<Compensation, HumanResourceService>implements
        Inputted<Compensation> {

    @Autowired
    private StartDatePicker startDatePicker;

    @Autowired
    private DailyRateField dailyRateField;

    public CompensationDialog() {
        super("Compensation");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(startDatePicker, dailyRateField);
    }

    @Override
    protected Compensation createEntity() {
        return new Compensation(startDatePicker.getValue(), dailyRateField
                .getValue());
    }
}
