package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class AllegationField extends LabeledStringField {

    public AllegationField() {
        super("Allegation");
    }
}
