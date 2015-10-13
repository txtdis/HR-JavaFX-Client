package ph.txtdis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;
import ph.txtdis.fx.dialog.LoginDialog;

@SpringBootApplication
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(
                App.class, "--debug");
        context.getBean(LoginDialog.class).showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
