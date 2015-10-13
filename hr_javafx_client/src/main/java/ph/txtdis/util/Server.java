package ph.txtdis.util;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.jasypt.properties.EncryptableProperties;
import org.springframework.stereotype.Component;

@Component
public class Server {

    private Properties props, encoded;
    private String address, name;
    private List<String> addresses;

    public Server() {
        props = loadProperties(new Properties());
        encoded = loadProperties(new EncryptableProperties(Temporal.encryptor()));
        createAddressList();
        setDefaultServer();
    }

    private void setDefaultServer() {
        name = props.getProperty("default.server");
    }

    public List<String> list() {
        return addresses;
    }

    private void createAddressList() {
        // @formatter:off
        addresses = props.stringPropertyNames().stream()
                .filter(p -> !p.contains("default"))
                .sorted((e1, e2) -> e1.compareTo(e2))
                .collect(Collectors.toList());
        // @formatter:on
    }

    public String setAddress(String name) {
        return address = props.getProperty(name);
    }

    public String address() {
        return address;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public String database() {
        return encoded.getProperty("default.database");
    }

    public String version() {
        return props.getProperty("default.version");
    }

    public String admin() {
        return encoded.getProperty("default.admin");
    }

    public String password() {
        return encoded.getProperty("default.password");
    }

    private Properties loadProperties(Properties props) {
        try {
            props.load(this.getClass().getResourceAsStream(
                    "/config/server.properties"));
            return props;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
