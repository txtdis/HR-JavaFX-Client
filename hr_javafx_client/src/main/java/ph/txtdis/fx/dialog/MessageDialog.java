package ph.txtdis.fx.dialog;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import ph.txtdis.fx.button.large.OkButton;
import ph.txtdis.fx.label.DialogIcon;
import ph.txtdis.fx.label.DialogMessage;
import ph.txtdis.fx.layout.DialogMessageBox;
import ph.txtdis.fx.layout.MessageDialogButtonBox;

public abstract class MessageDialog extends AbstractDialog {

    @Autowired
    private OkButton okButton;

    @Autowired
    private DialogIcon icon;

    @Autowired
    private DialogMessage message;

    @Autowired
    private MessageDialogButtonBox buttonBox;

    @Autowired
    private DialogMessageBox messageBox;

    public MessageDialog(String unicode, String color) {
        super(unicode + "$" + color);
    }

    public MessageDialog message(String text) {
        message.text(text);
        return this;
    }

    @Override
    protected Node[] nodes() {
        String[] texts = StringUtils.split(getTitle(), "$");
        icon.graphic(texts[0]).color(texts[1]);
        buttonBox.addButtons(okButton.close(this));
        messageBox.addNodes(message, buttonBox);
        return new Node[] { new HBox(icon, messageBox) };
    }
}
