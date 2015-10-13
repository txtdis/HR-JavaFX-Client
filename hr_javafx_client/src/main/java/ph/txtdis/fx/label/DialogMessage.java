package ph.txtdis.fx.label;

import org.springframework.stereotype.Component;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

@Component
public class DialogMessage extends Label {

    public DialogMessage() {
        setStyle("-fx-font-size: 11pt; ");
        setWrapText(true);
        setAlignment(Pos.CENTER);
        setTextAlignment(TextAlignment.CENTER);
        setPrefHeight(75);
        setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public DialogMessage text(String text) {
        setText(text);
        return this;
    }
}
