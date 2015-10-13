package ph.txtdis.fx.button;

public abstract class TextButton extends AbstractButton {

    public TextButton(String text) {
        super(text);
        setStyle("-fx-font-size: 11pt; ");
    }
}
