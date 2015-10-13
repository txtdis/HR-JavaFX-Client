package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class EmployerField extends LabeledStringField {

    public EmployerField() {
        super("Allegation");
    }
}
