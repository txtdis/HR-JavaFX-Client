package ph.txtdis.fx.dialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import ph.txtdis.dto.Style;
import ph.txtdis.dto.User;
import ph.txtdis.fx.StyleSheet;
import ph.txtdis.fx.colorpicker.AccentColorPicker;
import ph.txtdis.fx.colorpicker.BackgroundColorPicker;
import ph.txtdis.fx.colorpicker.BaseColorPicker;
import ph.txtdis.fx.combo.FontCombo;
import ph.txtdis.fx.gridpane.Grid;
import ph.txtdis.fx.label.AccentColorLabel;
import ph.txtdis.fx.label.BackgroundColorLabel;
import ph.txtdis.fx.label.BaseColorLabel;
import ph.txtdis.fx.label.FontLabel;
import ph.txtdis.service.UserService;
import ph.txtdis.util.Spring;

@Component
public class StyleDialog extends ServiceDialog<UserService> {

    @Autowired
    protected Grid grid;

    @Autowired
    private BaseColorLabel baseLabel;

    @Autowired
    private BaseColorPicker basePicker;

    @Autowired
    private BackgroundColorLabel backgroundLabel;

    @Autowired
    private BackgroundColorPicker backgroundPicker;

    @Autowired
    private AccentColorLabel accentLabel;

    @Autowired
    private AccentColorPicker accentPicker;

    @Autowired
    private FontLabel fontLabel;

    @Autowired
    private FontCombo fontCombo;

    @Autowired
    private StyleSheet styleSheet;

    public StyleDialog() {
        super("Change UI Theme");
    }

    @Override
    protected Node[] nodes() {
        grid.add(baseLabel, 0, 0);
        grid.add(basePicker, 1, 0);
        grid.add(backgroundLabel, 0, 1);
        grid.add(backgroundPicker, 1, 1);
        grid.add(accentLabel, 0, 2);
        grid.add(accentPicker, 1, 2);
        grid.add(fontLabel, 0, 3);
        grid.add(fontCombo, 1, 3);
        return new Node[] { header(), grid, buttonBox() };
    }

    @Override
    protected Button[] buttons() {
        return new Button[] { button("OK") };
    }

    @Override
    protected void process() {
        saveChanges();
        super.process();
    }

    private void saveChanges() {
        Style style = updateStyle();
        User user = updateUser(style);
        Spring.updateUser(user);
    }

    private Style updateStyle() {
        Style style = newStyle();
        styleSheet.update(style);
        return style;
    }

    private User updateUser(Style style) {
        User user = Spring.user();
        user.setStyle(style);
        user = service.save(user);
        return user;
    }

    private Style newStyle() {
        Style style = new Style();
        style.setBase(colorToRGBA(basePicker.getValue()));
        style.setBackground(colorToRGBA(backgroundPicker.getValue()));
        style.setAccent(colorToRGBA(accentPicker.getValue()));
        style.setFont(fontCombo.getValue());
        return style;
    }

    private String colorToRGBA(Color color) {
        return String.format("rgba(%d, %d, %d, %f)", (int) Math.round(color
                .getRed() * 255), (int) Math.round(color.getGreen() * 255),
                (int) Math.round(color.getBlue() * 255), color.getOpacity());
    }
}