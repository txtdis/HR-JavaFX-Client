package ph.txtdis.service;

import java.util.List;

import org.springframework.web.client.ResourceAccessException;

public interface Searched<T> {

    List<T> search(String criteria) throws ResourceAccessException;

    List<T> getSearchResult();
}
