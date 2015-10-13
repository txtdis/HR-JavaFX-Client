package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledIntegerField;

@Component
public class DayCountField extends LabeledIntegerField {

    public DayCountField() {
        super("Day/s");
    }
}
