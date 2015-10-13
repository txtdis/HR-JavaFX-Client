package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class ReasonForLeavingField extends LabeledStringField {

    public ReasonForLeavingField() {
        super("Reason for Leaving");
    }
}
