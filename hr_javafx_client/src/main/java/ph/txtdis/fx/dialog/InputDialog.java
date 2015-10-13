package ph.txtdis.fx.dialog;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import lombok.NoArgsConstructor;
import ph.txtdis.fx.button.large.CloseButton;
import ph.txtdis.fx.label.DialogHeader;
import ph.txtdis.fx.layout.DialogButtonBox;

@NoArgsConstructor
public abstract class InputDialog extends AbstractDialog {

    @Autowired
    protected CloseButton closeButton;

    @Autowired
    protected DialogHeader header;

    @Autowired
    protected DialogButtonBox box;

    public InputDialog(String name) {
        super(name);
    }

    protected HBox buttonBox() {
        return box.addButtons(buttons());
    }

    protected Label header() {
        return header.name(getTitle());
    }

    protected Button closeButton() {
        return button("Close");
    }

    protected Button button(String name) {
        closeButton.setOnAction(event -> process());
        closeButton.setText(name);
        return closeButton;
    }

    protected void process() {
        close();
    }

    protected Button[] buttons() {
        return new Button[] { closeButton() };
    }
}
