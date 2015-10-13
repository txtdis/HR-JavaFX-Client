package ph.txtdis.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class User implements Keyed<String> {

    private String username;

    private String password;

    private boolean enabled;

    private List<Authority> roles;

    private String email;

    private Style style;

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    @Override
    public String getId() {
        return username;
    }

    @Override
    public void setId(String id) {
        username = id;
    }

    @Override
    public String toString() {
        return username;
    }
}
