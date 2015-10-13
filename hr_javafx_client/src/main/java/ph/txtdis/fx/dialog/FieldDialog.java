package ph.txtdis.fx.dialog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.beans.binding.BooleanBinding;
import javafx.scene.Node;
import javafx.scene.control.Button;
import ph.txtdis.fx.button.large.AddButton;
import ph.txtdis.fx.gridpane.Grid;
import ph.txtdis.fx.input.InputNode;

public abstract class FieldDialog<T, S> extends InputDialog implements
        Inputted<T> {

    @Autowired
    protected Grid grid;

    @Autowired
    protected AddButton addButton;

    private List<T> addedItems;

    protected List<InputNode<?>> inputNodes;

    public FieldDialog(String name) {
        super(name + " Data Entry");
    }

    @Override
    public void showAndWait() {
        addedItems = new ArrayList<T>();
        super.showAndWait();
    }

    @Override
    protected Node[] nodes() {
        grid.getChildren().clear();
        inputNodes = addNodes();
        if (inputNodes != null) {
            for (int i = 0; i < inputNodes.size(); i++) {
                List<Node> nodes = inputNodes.get(i).getNodes();
                for (int j = 0; j < nodes.size(); j++)
                    grid.add(nodes.get(j), j, i);
            }
        }
        return new Node[] { header(), grid, buttonBox() };
    }

    protected void addItems() {
        addedItems.add(createEntity());
        resetNodes();
    }

    protected void resetNodes() {
        inputNodes.forEach(inputNode -> inputNode.reset());
        inputNodes.get(0).requestFocus();
    }

    @Override
    protected Button[] buttons() {
        return new Button[] { addButton(), closeButton() };
    }

    protected Button addButton() {
        addButton.setOnAction(event -> addItems());
        addButton.disableIf(getAddButtonBindings());
        return addButton;
    }

    protected BooleanBinding getAddButtonBindings() {
        BooleanBinding binding = inputNodes.get(0).isEmpty();
        for (int i = 1; i < inputNodes.size(); i++)
            binding = binding.or(inputNodes.get(i).isEmpty());
        return binding;
    }

    protected abstract List<InputNode<?>> addNodes();

    protected abstract T createEntity();

    @Override
    public List<T> getAddedItems() {
        return addedItems;
    }
}
