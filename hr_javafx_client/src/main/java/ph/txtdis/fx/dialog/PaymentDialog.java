package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import ph.txtdis.dto.Loan;
import ph.txtdis.dto.Payment;
import ph.txtdis.fx.button.large.AddButton;
import ph.txtdis.fx.button.large.CloseButton;
import ph.txtdis.fx.datepicker.ReceiptDatePicker;
import ph.txtdis.fx.field.AmountField;
import ph.txtdis.fx.gridpane.Grid;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.fx.label.DialogHeader;
import ph.txtdis.fx.layout.DialogButtonBox;

@Component
public class PaymentDialog extends FieldDialog<Payment, Loan>implements
        Inputted<Payment> {

    @Autowired
    private ReceiptDatePicker receiptDatePicker;

    @Autowired
    private AmountField amountField;

    public PaymentDialog() {
        super("Payment");
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
    protected Node[] nodes() {
        grid = new Grid();
        return super.nodes();
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        receiptDatePicker = new ReceiptDatePicker();
        amountField = new AmountField();
        return Arrays.asList(receiptDatePicker, amountField);
    }

    @Override
    protected Payment createEntity() {
        return new Payment(receiptDatePicker.getValue(), amountField
                .getValue());
    }

    @Override
    protected Button addButton() {
        addButton = new AddButton();
        return super.addButton();
    }
}
