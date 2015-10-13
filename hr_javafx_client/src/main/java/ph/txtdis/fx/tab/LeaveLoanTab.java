package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import ph.txtdis.fx.table.LeaveTable;
import ph.txtdis.fx.table.LoanTable;
import ph.txtdis.service.HumanResourceService;

@Component
public class LeaveLoanTab extends AbstractTab<HumanResourceService> {

    @Autowired
    private LeaveTable leave;

    @Autowired
    private LoanTable loan;

    public LeaveLoanTab() {
        super("Leave/Loan", "leaveLoan");
    }

    @Override
    protected Node[] addNodes() {
        return new Node[] { leave.getBox(), loan.getBox() };
    }

    @Override
    public void save() {
        service.setLeaves(leave.getItems());
        service.setLoans(loan.getItems());
    }

    @Override
    public void refresh() {
        leave.setItems(service.getLeaves());
        loan.setItems(service.getLoans());
    }
}
