package ph.txtdis.fx;

import java.math.BigDecimal;

import ph.txtdis.fx.input.StylableTextField;
import ph.txtdis.util.Numeric;

public class Styled {

    private static final String RIGHT_ALIGN = " -fx-alignment: center-right; ";

    private static final String RED = " -fx-text-fill: red ";

    public static void forInteger(StylableTextField text, Integer number) {
        text.setText(Numeric.formatInt(number));
        setNumberStyle(text, number);
    }

    public static void forIdNo(StylableTextField text, Long number) {
        text.setText(Numeric.formatId(number));
        setNumberStyle(text, number);
    }

    public static void forDecimal(StylableTextField text, BigDecimal number) {
        text.setText(Numeric.formatDecimal(number));
        setNumberStyle(text, number);
    }

    public static void forQuantity(StylableTextField text,
            BigDecimal number) {
        text.setText(Numeric.formatQuantity(number));
        setNumberStyle(text, number);
    }

    public static void forCurrency(StylableTextField text,
            BigDecimal number) {
        text.setText("₱" + Numeric.formatDecimal(number));
        setNumberStyle(text, number);
    }

    private static void setNumberStyle(StylableTextField text, Long number) {
        text.setStyle(RIGHT_ALIGN + (Numeric.isNegative(number) ? RED : ""));
    }

    private static void setNumberStyle(StylableTextField text, Integer number) {
        text.setStyle(RIGHT_ALIGN + (Numeric.isNegative(number) ? RED : ""));
    }

    private static void setNumberStyle(StylableTextField text,
            BigDecimal number) {
        text.setStyle(RIGHT_ALIGN + (Numeric.isNegative(number) ? RED : ""));
    }
}
