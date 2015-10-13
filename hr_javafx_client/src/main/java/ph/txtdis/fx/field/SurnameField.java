package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class SurnameField extends LabeledStringField {

    public SurnameField() {
        super("Last Name");
    }
}
