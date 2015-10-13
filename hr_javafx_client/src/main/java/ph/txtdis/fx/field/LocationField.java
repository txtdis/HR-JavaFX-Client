package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class LocationField extends LabeledStringField {

    public LocationField() {
        super("Location");
    }
}
