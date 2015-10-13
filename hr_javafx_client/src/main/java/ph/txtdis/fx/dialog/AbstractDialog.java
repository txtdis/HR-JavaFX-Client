package ph.txtdis.fx.dialog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractDialog extends Stage implements Owned {

    public AbstractDialog(String name) {
        setTitle(name);
    }

    @Override
    public AbstractDialog stage(Stage stage) {
        if (getOwner() == null)
            initialize(stage);
        return this;
    }

    @Override
    public void showAndWait() {
        setScene(scene(vbox(nodes())));
        setBindings();
        super.showAndWait();
    }

    private Scene scene(VBox vbox) {
        Scene s = new Scene(vbox);
        s.setFill(Color.TRANSPARENT);
        return s;
    }

    private VBox vbox(Node[] nodes) {
        VBox vb = new VBox();
        vb.getChildren().setAll(nodes);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(0, 20, 0, 20));
        // @formatter:off
        vb.setStyle(
                  "-fx-border-color: derive(-fx-base, -20%); "
                + "-fx-background-color: #aaaaff; "
                + "-fx-border-radius: 0.5em; "
                + "-fx-background-radius: 0.5em; ");
        // @formatter:off
        return vb;
    }

    private void initialize(Stage stage) {
        initOwner(stage);
        initModality(Modality.WINDOW_MODAL);
        initStyle(StageStyle.TRANSPARENT);
    }

    protected void setBindings() {
    }

    protected abstract Node[] nodes();
}
