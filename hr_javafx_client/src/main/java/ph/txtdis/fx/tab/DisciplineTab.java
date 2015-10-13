package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import ph.txtdis.fx.table.DisciplineTable;
import ph.txtdis.service.HumanResourceService;

@Component
public class DisciplineTab extends AbstractTab<HumanResourceService> {

    @Autowired
    private DisciplineTable table;

    public DisciplineTab() {
        super("Discipline", "discipline");
    }

    @Override
    protected Node[] addNodes() {
        return new Node[] { table.get() };
    }

    @Override
    public void save() {
        service.setDisciplinaryActions(table.getItems());
    }

    @Override
    public void refresh() {
        table.setItems(service.getDisciplinaryActions());
    }
}
