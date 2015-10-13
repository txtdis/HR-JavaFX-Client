package ph.txtdis.fx.tab;

import org.springframework.web.client.ResourceAccessException;

public interface Edited {

    void save() throws ResourceAccessException;

    void refresh();

    void setFocus();
}
