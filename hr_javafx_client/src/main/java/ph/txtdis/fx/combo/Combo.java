package ph.txtdis.fx.combo;

import java.util.Arrays;

import com.sun.javafx.scene.control.behavior.ComboBoxBaseBehavior;
import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

@SuppressWarnings("restriction")
public class Combo<T> extends ComboBox<T> {

    public Combo() {
        this(FXCollections.<T> observableArrayList());
    }

    @SuppressWarnings("unchecked")
    public Combo(T... items) {
        this(FXCollections.<T> observableList(Arrays.asList(items)));
    }

    public Combo(ObservableList<T> items) {
        super(items);
        if (items.size() == 1) {
            select(items.get(0));
            focusTraversableProperty().set(false);
        }
        traversePressedEnterKey();
    }

    @SuppressWarnings("unchecked")
    private void traversePressedEnterKey() {
        addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                ComboBoxListViewSkin<T> skin = (ComboBoxListViewSkin<T>) getSkin();
                ComboBoxBaseBehavior<T> behavior = skin.getBehavior();
                behavior.traverseNext();
            }
        });
    }

    public void select(T selection) {
        getSelectionModel().select(selection);
    }
}
