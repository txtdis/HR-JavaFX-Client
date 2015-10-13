package ph.txtdis.fx.dialog;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ph.txtdis.fx.button.large.FindButton;
import ph.txtdis.fx.gridpane.Grid;
import ph.txtdis.fx.input.StringField;

public abstract class SearchDialog extends InputDialog {

    @Autowired
    protected Grid grid;

    @Autowired
    private StringField textField;

    @Autowired
    private FindButton findButton;

    private String searchText;

    public SearchDialog(String module, String criteria) {
        super("Find a" + module + "$" + criteria);
    }

    @Override
    protected Label header() {
        String text = StringUtils.substringBefore(getTitle(), "$");
        return header.name(text);
    }

    @Override
    protected Node[] nodes() {
        String criteria = StringUtils.substringAfter(getTitle(), "$");
        Label help = new Label("Enter partial or full " + criteria
                + " to find a match; blank to list all");
        grid.getChildren().clear();
        grid.add(help, 0, 0);
        grid.add(textField, 0, 1);
        return new Node[] { header(), grid, buttonBox() };
    }

    @Override
    protected Button[] buttons() {
        return new Button[] { findButton(), closeButton() };
    }

    private Button findButton() {
        findButton.setOnAction(event -> {
            searchText = textField.getText();
            close();
        });
        return findButton;
    }

    public String getText() {
        return searchText;
    }
}
