package ph.txtdis.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.dto.User;

@Service
public class UserService extends AbstractCrudService<User, String> {

    public User find(String username) throws ResourceAccessException {
        return getOne("/" + username);
    }

    public User findByEmail(String email) throws ResourceAccessException {
        return getOne("/email?=" + email);
    }
}
