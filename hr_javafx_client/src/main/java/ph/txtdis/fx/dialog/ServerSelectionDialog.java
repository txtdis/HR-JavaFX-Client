package ph.txtdis.fx.dialog;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import ph.txtdis.fx.gridpane.Grid;
import ph.txtdis.fx.input.RadioControl;
import ph.txtdis.util.Server;

@Component
public class ServerSelectionDialog extends InputDialog {

    @Autowired
    private Server server;

    @Autowired
    protected Grid grid;

    private ToggleGroup group;

    public ServerSelectionDialog() {
        super("Choose Server");
    }

    @Override
    protected Node[] nodes() {
        group = new ToggleGroup();
        List<String> list = server.list();

        Map<String, RadioButton> buttons = new LinkedHashMap<>();
        list.forEach(s -> buttons.put(s, new RadioControl(s)));
        list.forEach(s -> buttons.get(s).setToggleGroup(group));

        grid.getChildren().clear();
        for (int i = 0; i < list.size(); i++)
            grid.add(buttons.get(list.get(i)), 0, i);

        buttons.get(server.name()).setSelected(true);
        return new Node[] { header(), grid, buttonBox() };
    }

    @Override
    protected Button[] buttons() {
        return new Button[] { button("OK") };
    }

    @Override
    protected void process() {
        RadioButton rb = ((RadioButton) group.getSelectedToggle());
        server.name(rb.getText());
        super.process();
    }
}
