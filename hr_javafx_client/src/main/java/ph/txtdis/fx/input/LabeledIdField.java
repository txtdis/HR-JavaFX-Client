package ph.txtdis.fx.input;

import ph.txtdis.util.Numeric;

public class LabeledIdField extends LabeledTextField<Integer> {

    public LabeledIdField(String name) {
        super(name, new IdNoField());
    }

    @Override
    public Integer getValue() {
        return Numeric.parseInteger(getText());
    }
}
