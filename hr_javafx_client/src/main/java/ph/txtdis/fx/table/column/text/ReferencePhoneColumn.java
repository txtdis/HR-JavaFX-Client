package ph.txtdis.fx.table.column.text;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.PastWork;
import ph.txtdis.fx.table.column.PhoneColumn;

@Component
public class ReferencePhoneColumn extends PhoneColumn<PastWork> {

    public ReferencePhoneColumn() {
        super("Phone", "referencePhone");
    }
}
