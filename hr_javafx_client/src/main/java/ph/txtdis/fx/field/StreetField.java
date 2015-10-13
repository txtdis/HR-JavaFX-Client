package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class StreetField extends LabeledStringField {

    public StreetField() {
        super("Street");
    }
}
