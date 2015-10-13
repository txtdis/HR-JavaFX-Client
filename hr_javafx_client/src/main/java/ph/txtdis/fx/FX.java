package ph.txtdis.fx;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FX {

    public static String colorToRGBA(Color color) {
        return String.format("rgba(%d, %d, %d, %f)", (int) Math.round(color
                .getRed() * 255), (int) Math.round(color.getGreen() * 255),
                (int) Math.round(color.getBlue() * 255), color.getOpacity());
    }

    public static void loadFont(String fontName) {
        Font.loadFont(FX.class.getResource("/font/" + fontName + ".ttf")
                .toExternalForm(), 24);
    }

    public static Stage stage(Scene scene) {
        return (Stage) scene.getWindow();
    }

    public static Stage stage(Node node) {
        return stage(node.getScene());
    }

    public static Stage stage(Tab tab) {
        return stage(tab.getTabPane());
    }
}
