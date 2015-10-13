package ph.txtdis.fx.tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ph.txtdis.fx.combo.Combo;
import ph.txtdis.fx.datepicker.LocalDatePicker;
import ph.txtdis.fx.display.ImageDisplay;
import ph.txtdis.fx.input.IdNoField;
import ph.txtdis.fx.input.PhoneField;
import ph.txtdis.fx.input.StringField;
import ph.txtdis.fx.table.AddressTable;
import ph.txtdis.fx.table.ContactInfoTable;
import ph.txtdis.service.HumanResourceService;
import ph.txtdis.type.CivilStatus;
import ph.txtdis.type.FamilyType;

@Component
public class PersonalTab extends AbstractTab<HumanResourceService> {

    @Autowired
    private AddressTable addressTable;

    @Autowired
    private ContactInfoTable contactInfoTable;

    private ImageDisplay photoLabel;
    private LocalDatePicker birthdatePicker;
    private Combo<CivilStatus> civilStatusCombo;
    private Combo<FamilyType> emergencyRelationCombo;
    private IdNoField idField;
    private StringField surnameField, nameField, middleInitialField,
            birthplaceField, emergencyContactField;
    private PhoneField emergencyPhoneField;

    public PersonalTab() {
        super("Personal", "personal");
    }

    @Override
    protected Node[] addNodes() {
        photoLabel = new ImageDisplay("photo");
        photoLabel.setPadding(0, 20, 0, 0);

        Label idLabel = new Label("ID No.");
        VBox idBox = new VBox(idLabel);
        idBox.setAlignment(Pos.CENTER_RIGHT);
        idField = new IdNoField();
        idField.setEditable(false);

        Label surnameLabel = new Label("Surname");
        surnameField = new StringField("");
        surnameField.setPromptText("LAST NAME");

        Label nameLabel = new Label("Name");
        nameField = new StringField("");
        nameField.setPromptText("GIVEN NAME/S");

        Label middleInitialLabel = new Label("M.I.");
        middleInitialField = new StringField("", 10);

        Label addressLabel = new Label("Address");

        Label birthdateLabel = new Label("Birthdate");
        birthdatePicker = new LocalDatePicker();

        Label birthPlaceLabel = new Label("Birthplace");
        birthplaceField = new StringField("");
        birthplaceField.setPromptText("CITY/TOWN, PROVINCE");

        Label civilStatusLabel = new Label("Civil Status");
        civilStatusCombo = new Combo<>(CivilStatus.values());

        Label emergencyLabel = new Label("Emergency Contact");
        emergencyLabel.setStyle("-fx-font-size: 16pt;");

        Label emergencyContactLabel = new Label("Name");
        emergencyContactField = new StringField("");

        Label emergencyRelationLabel = new Label("Relation");
        emergencyRelationCombo = new Combo<>(FamilyType.values());

        Label emergencyPhoneLabel = new Label("Phone");
        emergencyPhoneField = new PhoneField("");

        Label contactInfoLabel = new Label("Contact Information Details");
        contactInfoLabel.setStyle("-fx-font-size: 16pt;");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(photoLabel, 0, 0, 1, 10);
        gridPane.add(idBox, 5, 0);
        gridPane.add(idField, 6, 0, 2, 1);
        gridPane.add(surnameLabel, 1, 1);
        gridPane.add(surnameField, 2, 1);
        gridPane.add(nameLabel, 3, 1);
        gridPane.add(nameField, 4, 1, 2, 1);
        gridPane.add(middleInitialLabel, 6, 1);
        gridPane.add(middleInitialField, 7, 1);
        gridPane.add(addressLabel, 1, 2, 1, 2);
        gridPane.add(addressTable.get(), 2, 2, 6, 2);
        gridPane.add(birthdateLabel, 1, 4);
        gridPane.add(birthdatePicker, 2, 4);
        gridPane.add(birthPlaceLabel, 3, 4, 2, 1);
        gridPane.add(birthplaceField, 5, 4, 3, 1);
        gridPane.add(civilStatusLabel, 1, 5);
        gridPane.add(civilStatusCombo, 2, 5);
        gridPane.add(emergencyLabel, 1, 6, 2, 1);
        gridPane.add(emergencyContactLabel, 1, 7);
        gridPane.add(emergencyContactField, 2, 7);
        gridPane.add(emergencyRelationLabel, 1, 8);
        gridPane.add(emergencyRelationCombo, 2, 8);
        gridPane.add(emergencyPhoneLabel, 1, 9);
        gridPane.add(emergencyPhoneField, 2, 9);
        gridPane.add(contactInfoLabel, 3, 5, 5, 1);
        gridPane.add(contactInfoTable.get(), 3, 6, 5, 4);

        return new GridPane[] { gridPane };
    }

    @Override
    public void save() {
        service.setPhoto(photoLabel.getImage());
        service.setSurname(surnameField.getText());
        service.setName(nameField.getText());
        service.setMiddleInitial(middleInitialField.getText());
        service.setAddresses(addressTable.getItems());
        service.setBirthdate(birthdatePicker.getValue());
        service.setBirthplace(birthplaceField.getText());
        service.setCivilStatus(civilStatusCombo.getValue());
        service.setEmergencyContact(emergencyContactField.getText());
        service.setEmergencyRelation(emergencyRelationCombo.getValue());
        service.setEmergencyPhone(emergencyPhoneField.getPhone());
        service.setContactInfo(contactInfoTable.getItems());
    }

    @Override
    public void refresh() {
        idField.setIdNo(service.getId());
        photoLabel.setImage(service.getPhoto());
        surnameField.setText(service.getSurname());
        nameField.setText(service.getName());
        middleInitialField.setText(service.getMiddleInitial());
        addressTable.setItems(service.getAddresses());
        birthdatePicker.setValue(service.getBirthdate());
        birthplaceField.setText(service.getBirthplace());
        civilStatusCombo.getSelectionModel().select(service.getCivilStatus());
        emergencyContactField.setText(service.getEmergencyContact());
        emergencyRelationCombo.getSelectionModel().select(service
                .getEmergencyRelation());
        emergencyPhoneField.setPhone(service.getEmergencyPhone());
        contactInfoTable.setItems(service.getContactInfo());
    }

    public BooleanBinding isEmpty() {
        return surnameField.textProperty().isEmpty().or(nameField.textProperty()
                .isEmpty());
    }

    public void setFocus() {
        getTabPane().getSelectionModel().select(this);
        surnameField.requestFocus();
    }
}
