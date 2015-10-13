package ph.txtdis.fx.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.util.StringConverter;
import ph.txtdis.util.Temporal;

public class DateConverter extends StringConverter<LocalDate> {

    @Override
    public String toString(LocalDate date) {
        return Temporal.formatDate(date);
    }

    @Override
    public LocalDate fromString(String text) {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern("M/d/yy"));
    }
}
