package ph.txtdis.fx.table.column.check;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.table.column.CheckColumn;

@Component
public class NoticeGivenColumn extends CheckColumn<Discipline> {

    public NoticeGivenColumn() {
        super("Notice", "noticeGiven");
    }
}
