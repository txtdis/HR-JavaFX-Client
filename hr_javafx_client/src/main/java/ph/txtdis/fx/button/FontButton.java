package ph.txtdis.fx.button;

import ph.txtdis.fx.ToolTip;

public abstract class FontButton extends AbstractButton {

    public FontButton(String unicode, String tooltip) {
        this(unicode, tooltip, null);
    }

    public FontButton(String unicode, String tooltip, String color) {
        this(unicode, tooltip, color, 24);
    }

    public FontButton(String unicode, String tooltip, int size) {
        this(unicode, tooltip, null, size);
    }

    public FontButton(String unicode, String tooltip, String color, int size) {
        super(unicode);
        setTooltip(new ToolTip(tooltip));
        setStyle("-fx-font: " + size + " 'txtdis'; " + setColor(color)
                + "-fx-padding: 0; " + setSize(size));
    }

    private String setSize(int size) {
        int s = size * 2 - 2;
        return "-fx-min-width: " + s + "; -fx-max-width: " + s
                + "; -fx-min-height: " + s + "; -fx-max-height: " + s + ";";
    }

    private String setColor(String color) {
        return color == null ? "" : "-fx-text-fill: " + color + "; ";
    }
}
