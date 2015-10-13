package ph.txtdis.fx.dialog;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import ph.txtdis.dto.GovtId;
import ph.txtdis.fx.ImageUtil;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.fx.input.LabeledComboBox;
import ph.txtdis.fx.input.LabeledDatePicker;
import ph.txtdis.fx.input.LabeledStringField;
import ph.txtdis.service.HumanResourceService;
import ph.txtdis.type.GovtIdType;
import ph.txtdis.util.Binary;

@Component
public class GovtIdDialog extends FieldDialog<GovtId, HumanResourceService>
        implements Inputted<GovtId> {

    private LabeledComboBox<GovtIdType> typeCombo;
    private LabeledDatePicker issuedDatePicker;
    private LabeledDatePicker expiryDatePicker;
    private LabeledStringField detailField;

    public GovtIdDialog() {
        super("Government-Issued ID");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        typeCombo = new LabeledComboBox<>("Type", GovtIdType.values());
        issuedDatePicker = new LabeledDatePicker("Issuance");
        expiryDatePicker = new LabeledDatePicker("Expiry");
        detailField = new LabeledStringField("Detail");
        return Arrays.asList(typeCombo, issuedDatePicker, expiryDatePicker,
                detailField);
    }

    @Override
    protected GovtId createEntity() {
        byte[] image = Binary.toBytes(ImageUtil.defaultImageStream("id"));
        GovtIdType type = typeCombo.getValue();
        LocalDate issuance = issuedDatePicker.getValue();
        LocalDate expiry = expiryDatePicker.getValue();
        String detail = detailField.getValue();
        return new GovtId(image, type, issuance, expiry, detail);
    }
}
