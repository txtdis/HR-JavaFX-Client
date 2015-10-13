package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class ReferenceDesignationField extends LabeledStringField {

    public ReferenceDesignationField() {
        super("Reference Designation");
    }
}
