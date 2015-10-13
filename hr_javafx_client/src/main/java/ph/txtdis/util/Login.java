package ph.txtdis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.dto.User;
import ph.txtdis.exception.FailedAuthenticationException;
import ph.txtdis.exception.NoServerConnectionException;
import ph.txtdis.exception.StoppedServerException;
import ph.txtdis.service.UserService;

@Component
public class Login {

    @Autowired
    private UserService service;

    @Autowired
    private Server server;

    public void validate(String servername, String username, String password)
            throws NoServerConnectionException, StoppedServerException,
            FailedAuthenticationException {
        server.setAddress(servername);
        Spring.setCredentialsForValidation(username, password);
        User user = checkVsDatabase(username);
        Spring.setAuthentication(user, password, Spring.toGranted(user
                .getRoles()));
    }

    private User checkVsDatabase(String username)
            throws NoServerConnectionException, StoppedServerException,
            FailedAuthenticationException {
        try {
            return service.find(username);
        } catch (ResourceAccessException e) {
            e.printStackTrace();
            throw new NoServerConnectionException(server.name());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                if (e.getResponseBodyAsString().contains(
                        "This connection has been closed"))
                    throw new StoppedServerException();
                else
                    throw new FailedAuthenticationException();
            }
            e.printStackTrace();
            return null;
        }
    }
}
