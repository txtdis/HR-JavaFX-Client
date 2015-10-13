package ph.txtdis.service;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.dto.Keyed;

public abstract class AbstractCrudService<T extends Keyed<PK>, PK> extends
        AbstractReadService<T> {

    public List<T> getList() throws ResourceAccessException {
        return getList("");
    }

    @SuppressWarnings("unchecked")
    protected List<T> getList(String endpoint) throws ResourceAccessException {
        ResponseEntity<?> responseEntity = service.exchange(url() + endpoint,
                HttpMethod.GET, httpEntity(null), response.type(group));
        return (List<T>) responseEntity.getBody();
    }

    public boolean delete(PK id) throws ResourceAccessException {
        ResponseEntity<String> entity = service.exchange(url() + "/" + id,
                HttpMethod.DELETE, httpEntity(null), String.class);
        return entity.getStatusCode() == HttpStatus.NO_CONTENT;
    }

    @SuppressWarnings("unchecked")
    public T save(T entity) throws ResourceAccessException {
        return (T) service.postForObject(url(), httpEntity(entity), entity
                .getClass());
    }
}
