package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class DesignationField extends LabeledStringField {

    public DesignationField() {
        super("Designation");
    }
}
