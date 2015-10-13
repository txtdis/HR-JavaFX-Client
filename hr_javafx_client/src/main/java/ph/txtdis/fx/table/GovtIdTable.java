package ph.txtdis.fx.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.GovtId;
import ph.txtdis.fx.dialog.GovtIdDialog;
import ph.txtdis.fx.table.column.combo.GovtIdTypeColumn;
import ph.txtdis.fx.table.column.date.ExpiryColumn;
import ph.txtdis.fx.table.column.date.IssuanceColumn;
import ph.txtdis.fx.table.column.image.IdCardColumn;
import ph.txtdis.fx.table.column.text.GovtIdDetailColumn;

@Component
public class GovtIdTable extends InputTable<GovtId, GovtIdDialog> {

    @Autowired
    private IdCardColumn imageCol;

    @Autowired
    private GovtIdTypeColumn typeCol;

    @Autowired
    private IssuanceColumn issuanceCol;

    @Autowired
    private ExpiryColumn expiryCol;

    @Autowired
    private GovtIdDetailColumn detailCol;

    @Override
    @SuppressWarnings("unchecked")
    protected void addColumns() {
        getColumns().setAll(imageCol, typeCol, issuanceCol, expiryCol,
                detailCol);
    }
}
