package ph.txtdis.util;

import java.util.HashMap;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Authority;
import ph.txtdis.dto.Backup;
import ph.txtdis.dto.Employee;
import ph.txtdis.dto.Style;
import ph.txtdis.dto.User;

@Component
public class TypeReferenceMap extends
        HashMap<String, ParameterizedTypeReference<?>> {

    private static final long serialVersionUID = -1782679034968493608L;

    public TypeReferenceMap() {
        super();
        put("backup", new ParameterizedTypeReference<Backup>() {
        });
        put("employees", new ParameterizedTypeReference<List<Employee>>() {
        });
        put("employee", new ParameterizedTypeReference<Employee>() {
        });
        put("roles", new ParameterizedTypeReference<List<Authority>>() {
        });
        put("role", new ParameterizedTypeReference<Authority>() {
        });
        put("styles", new ParameterizedTypeReference<List<Style>>() {
        });
        put("style", new ParameterizedTypeReference<Style>() {
        });
        put("users", new ParameterizedTypeReference<List<User>>() {
        });
        put("user", new ParameterizedTypeReference<User>() {
        });
    }

    public ParameterizedTypeReference<?> type(String path) {
        return get(path);
    }
}
