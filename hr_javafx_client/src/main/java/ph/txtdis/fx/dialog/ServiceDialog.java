package ph.txtdis.fx.dialog;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ServiceDialog<S> extends InputDialog {

    @Autowired
    protected S service;

    public ServiceDialog(String name) {
        super(name);
    }
}
