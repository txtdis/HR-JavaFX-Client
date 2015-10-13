package ph.txtdis.service;

import org.atteo.evo.inflector.English;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.util.HttpHeader;
import ph.txtdis.util.Server;
import ph.txtdis.util.Text;
import ph.txtdis.util.TypeReferenceMap;

public abstract class AbstractReadService<T> {

    @Autowired
    protected RestService service;

    @Autowired
    protected TypeReferenceMap response;

    @Autowired
    private Server server;

    @Autowired
    private HttpHeader http;

    protected String group, single;

    public AbstractReadService() {
        single = Text.singular(this);
        group = English.plural(single);
    }

    protected String url() {
        return "https://" + server.address() + ":8443/" + group;
    }

    @SuppressWarnings("unchecked")
    protected T getOne(String endpoint) throws ResourceAccessException {
        ResponseEntity<?> responseEntity = service.exchange(url() + endpoint,
                HttpMethod.GET, httpEntity(null), response.type(single));
        T entity = (T) responseEntity.getBody();
        return entity;
    }

    protected HttpEntity<T> httpEntity(T entity) {
        return new HttpEntity<T>(entity, http.headers());
    }
}
