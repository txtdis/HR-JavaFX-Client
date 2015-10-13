package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import ph.txtdis.fx.table.PastWorkTable;
import ph.txtdis.service.HumanResourceService;

@Component
public class PastWorkTab extends AbstractTab<HumanResourceService> {

    @Autowired
    private PastWorkTable table;

    public PastWorkTab() {
        super("Past Work", "work");
    }

    @Override
    protected Node[] addNodes() {
        return new Node[] { table.get() };
    }

    @Override
    public void save() {
        service.setPastJobs(table.getItems());
    }

    @Override
    public void refresh() {
        table.setItems(service.getPastJobs());
    }
}
