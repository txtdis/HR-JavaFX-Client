package ph.txtdis.fx.datepicker;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledDatePicker;

@Component
public class StartDatePicker extends LabeledDatePicker {

    public StartDatePicker() {
        super("Start");
    }

}
