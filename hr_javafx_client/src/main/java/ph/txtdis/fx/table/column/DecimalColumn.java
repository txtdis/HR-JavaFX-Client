package ph.txtdis.fx.table.column;

import java.math.BigDecimal;

public abstract class DecimalColumn<S> extends
        AbstractColumn<S, BigDecimal> {

    public DecimalColumn(String name, String volSuffix) {
        super(name, volSuffix, 100);
    }
}
