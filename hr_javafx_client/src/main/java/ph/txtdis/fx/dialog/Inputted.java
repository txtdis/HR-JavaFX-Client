package ph.txtdis.fx.dialog;

import java.util.List;

public interface Inputted<T> {

    void showAndWait();

    List<T> getAddedItems();
}
