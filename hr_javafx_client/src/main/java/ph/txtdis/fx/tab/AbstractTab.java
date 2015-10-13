package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractTab<S> extends Tab implements InputTab {

    @Autowired
    protected S service;

    public AbstractTab(String name, String id) {
        setText(name);
        setId(id);
    }

    protected Node addContent() {
        HBox box = new HBox();
        box.getChildren().addAll(addNodes());
        box.setSpacing(10);
        box.setPadding(new Insets(5));
        box.setAlignment(Pos.CENTER);
        return box;
    }

    protected abstract Node[] addNodes();

    @Override
    public Tab tab() {
        setContent(addContent());
        return this;
    }
}
