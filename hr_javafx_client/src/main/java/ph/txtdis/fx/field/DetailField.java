package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class DetailField extends LabeledStringField {

    public DetailField() {
        super("Detail");
    }
}
