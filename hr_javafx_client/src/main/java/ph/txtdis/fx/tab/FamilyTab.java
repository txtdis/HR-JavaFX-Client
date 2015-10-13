package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import ph.txtdis.fx.table.FamilyTable;
import ph.txtdis.service.HumanResourceService;

@Component
public class FamilyTab extends AbstractTab<HumanResourceService> {

    @Autowired
    private FamilyTable table;

    public FamilyTab() {
        super("Family", "family");
    }

    @Override
    protected Node[] addNodes() {
        return new Node[] { table.get() };
    }

    @Override
    public void save() {
        service.setRelatives(table.getItems());
    }

    @Override
    public void refresh() {
        table.setItems(service.getRelatives());
    }
}
