package ph.txtdis.fx.dialog;

import java.util.List;

import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import ph.txtdis.dto.Loan;
import ph.txtdis.dto.Payment;
import ph.txtdis.fx.button.large.CloseButton;
import ph.txtdis.fx.gridpane.Grid;
import ph.txtdis.fx.label.DialogHeader;
import ph.txtdis.fx.layout.DialogButtonBox;
import ph.txtdis.fx.table.PaymentTable;

@Component
public class PaymentTableDialog extends InputDialog implements Sourced<Loan> {

    private Loan service;

    private PaymentTable table;

    public PaymentTableDialog() {
        super("Payment List");
    }

    @Override
    protected HBox buttonBox() {
        box = new DialogButtonBox();
        return super.buttonBox();
    }

    @Override
    protected Label header() {
        header = new DialogHeader();
        return super.header();
    }

    @Override
    protected Button button(String name) {
        closeButton = new CloseButton();
        return super.button(name);
    }

    @Override
    public void setSource(Loan loan) {
        service = loan;
    }

    @Override
    protected Node[] nodes() {
        table = new PaymentTable();
        table.get();
        table.setItems(FXCollections.observableArrayList(service
                .getPayments()));
        Grid grid = new Grid();
        grid.add(table, 0, 0);
        return new Node[] { header(), grid, buttonBox() };
    }

    public List<Payment> getItems() {
        return table.getItems();
    }
}
