package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import ph.txtdis.fx.table.EducationTable;
import ph.txtdis.service.HumanResourceService;

@Component
public class EducationTab extends AbstractTab<HumanResourceService> {

    @Autowired
    private EducationTable table;

    public EducationTab() {
        super("Education", "education");
    }

    @Override
    protected Node[] addNodes() {
        return new Node[] { table.get() };
    }

    @Override
    public void save() {
        service.setStudies(table.getItems());
    }

    @Override
    public void refresh() {
        table.setItems(service.getStudies());
    }
}