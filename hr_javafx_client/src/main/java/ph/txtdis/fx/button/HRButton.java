package ph.txtdis.fx.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.app.EmployeeApp;

@Component
public class HRButton extends FontButton {

    @Autowired
    private EmployeeApp app;

    public HRButton() {
        super("\ue811", "Human Resources", 44);
        setOnAction(event -> app.start());
    }
}
