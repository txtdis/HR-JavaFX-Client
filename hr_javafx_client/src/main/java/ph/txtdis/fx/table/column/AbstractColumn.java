package ph.txtdis.fx.table.column;

import org.springframework.util.StringUtils;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import ph.txtdis.util.Reflection;

public abstract class AbstractColumn<S, T> extends TableColumn<S, T> {

    public AbstractColumn(String text, String field, int minWidth) {
        super(text);
        setCellValueFactory(new PropertyValueFactory<>(field));
        makeHeaderWrappable();
        setId(field);
        setMinWidth(minWidth);
        setPrefWidth(minWidth);
        setOnEditCommit(field);
        setTableCells();
    }

    protected void setOnEditCommit(String field) {
        // @formatter:off
        setOnEditCommit(event -> Reflection.invokeOneParameterMethod(
                event.getRowValue(),
                "set" + StringUtils.capitalize(field),
                event.getNewValue(),
                event.getNewValue().getClass()));
        // @formatter:on
    }

    private void makeHeaderWrappable() {
        Label label = new Label(getText());
        label.setStyle("-fx-padding: 8px;");
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);

        StackPane stack = new StackPane();
        stack.getChildren().add(label);
        stack.prefWidthProperty().bind(widthProperty().subtract(5));
        label.prefWidthProperty().bind(stack.prefWidthProperty());
        setGraphic(stack);
    }

    protected abstract void setTableCells();
}