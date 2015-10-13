package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class ReferenceNameField extends LabeledStringField {

    public ReferenceNameField() {
        super("Reference Name");
    }
}
