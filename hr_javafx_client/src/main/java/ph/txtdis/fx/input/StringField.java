package ph.txtdis.fx.input;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import ph.txtdis.fx.ToolTip;

@Component
public class StringField extends InputField {

    public StringField() {
        this(256);
    }

    public StringField(String text) {
        this(text, 256);
    }

    public StringField(String text, int maxLength) {
        this(maxLength);
        setTooltip(new ToolTip("Double-click to edit;\nuse tab to traverse"));
        setText(text);
    }

    public StringField(int maxLength) {
        if (maxLength < 256) {
            setMaxWidth(maxLength * 12);
            setPrefWidth(maxLength * 12);
        }

        textProperty().addListener(new ChangeListener<String>() {
            private boolean ignore;
            private IntegerProperty maximumLength = new SimpleIntegerProperty(
                    maxLength);

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (ignore || newValue == null)
                    return;
                if (newValue.length() > maximumLength.get()) {
                    ignore = true;
                    setText(newValue.substring(0, maximumLength.get()));
                    ignore = false;
                } else {
                    setText(StringUtils.upperCase(newValue));
                }
            }
        });
    }
}