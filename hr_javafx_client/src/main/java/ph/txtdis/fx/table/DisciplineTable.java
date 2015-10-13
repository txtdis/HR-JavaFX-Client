package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.dialog.DisciplineDialog;
import ph.txtdis.fx.table.column.check.DecisionGivenColumn;
import ph.txtdis.fx.table.column.check.DocumentationGivenReceivedColumn;
import ph.txtdis.fx.table.column.check.NoticeGivenColumn;
import ph.txtdis.fx.table.column.check.ReplyReceivedColumn;
import ph.txtdis.fx.table.column.date.EffectivityColumn;
import ph.txtdis.fx.table.column.date.IncidenceColumn;
import ph.txtdis.fx.table.column.integer.DisciplineDayCountColumn;
import ph.txtdis.fx.table.column.text.AllegationColumn;
import ph.txtdis.fx.table.column.text.DecisionColumn;

@Component
public class DisciplineTable extends InputTable<Discipline, DisciplineDialog> {

    @Autowired
    private NoticeGivenColumn noticeCol;

    @Autowired
    private ReplyReceivedColumn replyCol;

    @Autowired
    private DecisionGivenColumn rulingCol;

    @Autowired
    private IncidenceColumn incidenceCol;

    @Autowired
    private AllegationColumn allegationCol;

    @Autowired
    private DecisionColumn decisionCol;

    @Autowired
    private EffectivityColumn effectivityCol;

    @Autowired
    private DisciplineDayCountColumn dayCountCol;

    @Autowired
    private DocumentationGivenReceivedColumn documentationCol;

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        documentationCol.getColumns().setAll(noticeCol, replyCol, rulingCol);
        getColumns().setAll(incidenceCol, allegationCol, decisionCol,
                effectivityCol, dayCountCol, documentationCol);
    }
}
