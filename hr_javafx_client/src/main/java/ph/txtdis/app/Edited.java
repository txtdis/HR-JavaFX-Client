package ph.txtdis.app;

import ph.txtdis.exception.InvalidException;

public interface Edited {

    void save() throws InvalidException;

    void refresh();
}
