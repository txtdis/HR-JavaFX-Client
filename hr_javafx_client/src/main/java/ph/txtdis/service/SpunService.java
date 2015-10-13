package ph.txtdis.service;

import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.dto.Keyed;

public interface SpunService<T extends Keyed<PK>, PK> {

    T next(PK id) throws ResourceAccessException;

    T previous(PK id) throws ResourceAccessException;
}
