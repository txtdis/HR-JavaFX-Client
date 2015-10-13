package ph.txtdis.fx.dialog;

import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class ProgressDialog extends AbstractDialog {

    public ProgressDialog() {
        super(null);
        show();
        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() {
                begin();
                return null;
            }

            @Override
            protected void succeeded() {
                super.succeeded();
                close();
                next();
            }
        };

        new Thread(task).start();
    }

    @Override
    protected Node[] nodes() {
        Label label = new Label("Preparing data...");
        label.setStyle("-fx-font-size: 26pt;");

        ProgressBar bar = new ProgressBar(-1.0);
        bar.setScaleX(2.5);
        HBox barBox = new HBox(bar);
        barBox.setAlignment(Pos.CENTER);
        barBox.setPadding(new Insets(0, 0, 20, 0));

        VBox dialogBox = new VBox(label, barBox);
        return new Node[] { dialogBox };
    }

    protected abstract void begin();

    protected abstract void next();
}
