package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class ReferencePhoneField extends LabeledStringField {

    public ReferencePhoneField() {
        super("Reference Phone");
    }
}
