package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import javafx.scene.control.TableColumn;
import ph.txtdis.dto.PastWork;

@Component
public class ReferenceColumn extends TableColumn<PastWork, String> {

    public ReferenceColumn() {
        super("Reference");
    }
}
