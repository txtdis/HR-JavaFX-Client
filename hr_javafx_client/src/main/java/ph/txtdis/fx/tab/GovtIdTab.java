package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import ph.txtdis.fx.table.GovtIdTable;
import ph.txtdis.service.HumanResourceService;

@Component
public class GovtIdTab extends AbstractTab<HumanResourceService> {

    @Autowired
    private GovtIdTable table;

    public GovtIdTab() {
        super("Gov't ID", "govtId");
    }

    @Override
    protected Node[] addNodes() {
        return new Node[] { table.get() };
    }

    @Override
    public void save() {
        service.setGovtIds(table.getItems());
    }

    @Override
    public void refresh() {
        table.setItems(service.getGovtIds());
    }
}
