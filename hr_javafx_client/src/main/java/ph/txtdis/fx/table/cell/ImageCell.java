package ph.txtdis.fx.table.cell;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import ph.txtdis.fx.ImageUtil;

public class ImageCell<T> extends TableCell<T, byte[]> {

    public ImageCell() {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        addEventFilter(MouseEvent.MOUSE_CLICKED,
                event -> loadImageOnDoubleClick(event));
    }

    private void loadImageOnDoubleClick(MouseEvent event) {
        if (event.getClickCount() > 1)
            loadImage();
        event.consume();
    }

    private void loadImage() {
        byte[] imageBytes = ImageUtil.imageBytesFromFile(getScene());
        if (imageBytes != null)
            commitEdit(imageBytes);
    }

    @Override
    public void updateItem(byte[] bytes, boolean empty) {
        super.updateItem(bytes, empty);
        if (!empty)
            setGraphic(ImageUtil.toImageView(bytes));
        setText(null);
    }
}
