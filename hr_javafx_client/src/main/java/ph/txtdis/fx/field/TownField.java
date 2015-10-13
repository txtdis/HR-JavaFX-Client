package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class TownField extends LabeledStringField {

    public TownField() {
        super("Town/District");
    }
}
