package ph.txtdis.fx.field;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.input.LabeledStringField;

@Component
public class ProgramField extends LabeledStringField {

    public ProgramField() {
        super("Program/Course");
    }
}
