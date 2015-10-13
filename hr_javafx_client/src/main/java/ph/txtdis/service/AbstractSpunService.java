package ph.txtdis.service;

import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.dto.Keyed;

public abstract class AbstractSpunService<T extends Keyed<PK>, PK> extends
        AbstractCrudService<T, PK>implements SpunService<T, PK> {

    @Override
    public T next(PK id) throws ResourceAccessException {
        return getFirstForNewOrLastElseNext(id);
    }

    @Override
    public T previous(PK id) throws ResourceAccessException {
        return getLastForNewOrFirstElsePrevious(id);
    }

    private T first() throws ResourceAccessException {
        return getOne("/first");
    }

    private T last() throws ResourceAccessException {
        return getOne("/last");
    }

    private T getFirstForNewOrLastElseNext(PK id)
            throws ResourceAccessException {
        return id == null || isLast(id) ? first() : getNext(id);
    }

    private boolean isLast(PK id) throws ResourceAccessException {
        return last().getId().equals(id);
    }

    private T getNext(PK id) throws ResourceAccessException {
        return getOne("/next?id=" + id);
    }

    private T getLastForNewOrFirstElsePrevious(PK id)
            throws ResourceAccessException {
        return id == null || isFirst(id) ? last() : getPrevious(id);
    }

    private boolean isFirst(PK id) throws ResourceAccessException {
        return first().getId().equals(id);
    }

    private T getPrevious(PK id) throws ResourceAccessException {
        return getOne("/previous?id=" + id);
    }
}
