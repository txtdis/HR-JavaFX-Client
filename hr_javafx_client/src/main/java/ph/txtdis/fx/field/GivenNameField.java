package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class GivenNameField extends LabeledStringField {

    public GivenNameField() {
        super("Given Name/s");
    }
}
