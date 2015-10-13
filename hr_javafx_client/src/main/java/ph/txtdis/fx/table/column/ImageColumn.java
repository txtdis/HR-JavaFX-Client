package ph.txtdis.fx.table.column;

import ph.txtdis.fx.table.cell.ImageCell;

public abstract class ImageColumn<S> extends AbstractColumn<S, byte[]> {

    public ImageColumn(String name, String imageSuffix) {
        super(name, imageSuffix, 210);
    }

    @Override
    protected void setTableCells() {
        setCellFactory(c -> new ImageCell<S>());
    }
}
