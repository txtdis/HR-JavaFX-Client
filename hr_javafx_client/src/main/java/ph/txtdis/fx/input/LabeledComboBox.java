package ph.txtdis.fx.input;

import java.util.Arrays;
import java.util.List;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import ph.txtdis.fx.combo.Combo;

public class LabeledComboBox<T> implements InputNode<T> {
    private final List<Node> nodes;
    private final Combo<T> comboBox;

    public LabeledComboBox(String name, T[] types) {
        this(name, FXCollections.observableArrayList(types));
    }

    public LabeledComboBox(String name, ObservableList<T> items) {
        Label label = new Label(name);
        label.setMinWidth(name.length() * 9);
        comboBox = new Combo<>(items);
        nodes = Arrays.asList(label, comboBox);
    }

    @Override
    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public T getValue() {
        return comboBox.getValue();
    }

    @Override
    public void reset() {
        comboBox.setValue(null);
    }

    @Override
    public void requestFocus() {
        comboBox.requestFocus();
    }

    @Override
    public BooleanBinding isEmpty() {
        return comboBox.valueProperty().isNull();
    }

    public void setItems(List<T> list) {
        comboBox.setItems(FXCollections.observableList(list));
    }

    public void setSelection(T item) {
        comboBox.getSelectionModel().select(item);
    }
}
