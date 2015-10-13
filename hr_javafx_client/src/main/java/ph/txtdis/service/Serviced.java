package ph.txtdis.service;

import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.dto.Keyed;

public interface Serviced<T, PK> extends Keyed<PK> {

    void reset();

    void save() throws ResourceAccessException;

    T get();

    void set(T entity);

    T find(PK id) throws ResourceAccessException;
}
