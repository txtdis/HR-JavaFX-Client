package ph.txtdis.fx.input;

import ph.txtdis.util.Numeric;

public class LabeledIntegerField extends LabeledTextField<Integer> {

    public LabeledIntegerField(String name) {
        super(name, new IntegerField());
    }

    @Override
    public Integer getValue() {
        return Numeric.parseInteger(getText());
    }
}
