package ph.txtdis.fx.table.column.image;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.GovtId;
import ph.txtdis.fx.table.column.ImageColumn;

@Component
public class IdCardColumn extends ImageColumn<GovtId> {

    public IdCardColumn() {
        super("ID Card", "image");
    }
}
