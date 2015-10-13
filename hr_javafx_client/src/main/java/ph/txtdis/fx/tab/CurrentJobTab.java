package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import ph.txtdis.fx.table.AssignmentTable;
import ph.txtdis.fx.table.CompensationTable;
import ph.txtdis.service.HumanResourceService;

@Component
public class CurrentJobTab extends AbstractTab<HumanResourceService> {

    @Autowired
    private AssignmentTable assignment;

    @Autowired
    private CompensationTable compensation;

    public CurrentJobTab() {
        super("Current Job", "job");
    }

    @Override
    protected Node[] addNodes() {
        return new Node[] { assignment.getBox(), compensation
                .getBox() };
    }

    @Override
    public void save() {
        service.setAssignments(assignment.getItems());
        service.setDailyRates(compensation.getItems());
    }

    @Override
    public void refresh() {
        assignment.setItems(service.getAssignments());
        compensation.setItems(service.getDailyRates());
    }
}
