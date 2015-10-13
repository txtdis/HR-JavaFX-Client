package ph.txtdis.service;

import org.springframework.web.client.ResourceAccessException;

public interface Spun {

    void previous() throws ResourceAccessException;

    void next() throws ResourceAccessException;
}
