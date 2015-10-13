package ph.txtdis.fx.table.column.check;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.table.column.CheckColumn;

@Component
public class ReplyReceivedColumn extends CheckColumn<Discipline> {

    public ReplyReceivedColumn() {
        super("Reply", "replyReceived");
    }
}
