package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.dialog.PastWorkDialog;
import ph.txtdis.fx.table.column.currency.LastPayColumn;
import ph.txtdis.fx.table.column.date.PastWorkEndColumn;
import ph.txtdis.fx.table.column.date.PastWorkStartColumn;
import ph.txtdis.fx.table.column.text.ExDesignationColumn;
import ph.txtdis.fx.table.column.text.ExEmployerColumn;
import ph.txtdis.fx.table.column.text.ReasonForLeavingColumn;
import ph.txtdis.fx.table.column.text.ReferenceColumn;
import ph.txtdis.fx.table.column.text.ReferenceDesignationColumn;
import ph.txtdis.fx.table.column.text.ReferenceNameColumn;
import ph.txtdis.fx.table.column.text.ReferencePhoneColumn;

@Component
public class PastWorkTable extends InputTable<PastWork, PastWorkDialog> {

    @Autowired
    private PastWorkStartColumn startCol;

    @Autowired
    private PastWorkEndColumn endCol;

    @Autowired
    private ExEmployerColumn employerCol;

    @Autowired
    private ExDesignationColumn designationCol;

    @Autowired
    private ReasonForLeavingColumn reasonForLeavingCol;

    @Autowired
    private LastPayColumn lastPayCol;

    @Autowired
    private ReferenceNameColumn referenceNameCol;

    @Autowired
    private ReferenceDesignationColumn referenceDesignationCol;

    @Autowired
    private ReferencePhoneColumn referencePhoneCol;

    @Autowired
    private ReferenceColumn referenceCol;

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        // @formatter:off
        referenceCol.getColumns().setAll(
                referenceNameCol,
                referenceDesignationCol,
                referencePhoneCol);
        getColumns().setAll(
                startCol,
                endCol,
                employerCol,
                designationCol,
                lastPayCol,
                reasonForLeavingCol,
                referenceCol);
        // @formatter:on
    }
}
