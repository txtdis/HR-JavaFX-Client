package ph.txtdis.fx.table.column.check;

import org.springframework.stereotype.Component;

import javafx.scene.control.TableColumn;
import ph.txtdis.dto.Discipline;

@Component
public class DocumentationGivenReceivedColumn extends TableColumn<Discipline, String> {

    public DocumentationGivenReceivedColumn() {
        super("Documentation\nGiven/Received");
    }
}
