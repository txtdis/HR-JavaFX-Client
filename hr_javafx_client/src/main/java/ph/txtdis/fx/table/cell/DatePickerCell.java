package ph.txtdis.fx.table.cell;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import ph.txtdis.fx.converter.DateConverter;
import ph.txtdis.fx.datepicker.LocalDatePicker;

public class DatePickerCell<T> extends TableCell<T, LocalDate> {
    private final DatePicker datePicker;

    public DatePickerCell() {
        datePicker = new LocalDatePicker();
        datePicker.setConverter(new DateConverter());
        datePicker.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER || event
                    .getCode() == KeyCode.TAB) {
                datePicker.setValue(datePicker.getConverter().fromString(
                        datePicker.getEditor().getText()));
                commitEdit(datePicker.getValue());
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });

        datePicker.setDayCellFactory(picker -> {
            DateCell cell = new DateCell();
            cell.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
                datePicker.setValue(cell.getItem());
                if (event.getClickCount() == 2) {
                    datePicker.hide();
                    commitEdit(cell.getItem());
                }
                event.consume();
            });
            cell.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    commitEdit(datePicker.getValue());
                }
                event.consume();
            });
            return cell;
        });

        contentDisplayProperty().bind(Bindings.when(editingProperty()).then(
                ContentDisplay.GRAPHIC_ONLY).otherwise(
                        ContentDisplay.TEXT_ONLY));
    }

    @Override
    public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        if (date != null)
            setText(date.format(DateTimeFormatter.ofPattern("M/d/yy")));
        else
            setText("");
        setGraphic(datePicker);
        setStyle("-fx-alignment: top-center;");
    }

    @Override
    public void startEdit() {
        super.startEdit();
        datePicker.setValue(getDate());
        setGraphic(datePicker);
    }

    private LocalDate getDate() {
        if (getText() == null)
            return LocalDate.now();
        return LocalDate.parse(getText(), DateTimeFormatter.ofPattern(
                "M/d/yy"));
    }
}
