package ph.txtdis.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ph.txtdis.dto.Audited;
import ph.txtdis.exception.InvalidException;
import ph.txtdis.exception.NotFoundException;
import ph.txtdis.fx.button.BackButton;
import ph.txtdis.fx.button.GetButton;
import ph.txtdis.fx.button.NewButton;
import ph.txtdis.fx.button.NextButton;
import ph.txtdis.fx.button.SaveButton;
import ph.txtdis.fx.dialog.ErrorDialog;
import ph.txtdis.fx.dialog.InfoDialog;
import ph.txtdis.fx.dialog.OpenEmployeeDialog;
import ph.txtdis.fx.display.TimestampDisplay;
import ph.txtdis.fx.display.UserDisplay;
import ph.txtdis.service.Serviced;
import ph.txtdis.service.Spun;

public abstract class AbstractIdApp<T, S extends Serviced<T, Long>> extends AbstractApp<T, Long> {

	@Autowired
	protected S service;

	@Autowired
	protected NewButton newButton;

	@Autowired
	protected BackButton backButton;

	@Autowired
	protected GetButton openButton;

	@Autowired
	protected NextButton nextButton;

	@Autowired
	protected SaveButton saveButton;

	@Autowired
	protected OpenEmployeeDialog openDialog;

	@Autowired
	private ErrorDialog error;

	@Autowired
	private InfoDialog info;

	protected UserDisplay encoderDisplay;
	protected TimestampDisplay timestampDisplay;
	protected HBox summaryBox, userHBox;

	public AbstractIdApp(String module, String abbr) {
		super(module, abbr);
	}

	@Override
	public void start() {
		super.start();
		reset();
	}

	@Override
	public void refresh() {
		updateCreationStamps();
		super.refresh();
	}

	protected void updateCreationStamps() {
		if (encoderDisplay != null) {
			encoderDisplay.setText(((Audited) service).getCreatedBy());
			timestampDisplay.setTimestamp(((Audited) service).getCreatedOn());
		}
	}

	@Override
	protected void setButtons() {
		super.setButtons();
		newButton.setOnAction(e -> reset());
		backButton.setOnAction(e -> tryPrevious());
		openButton.setOnAction(e -> tryOpening());
		nextButton.setOnAction(e -> tryNext());
		saveButton.setOnAction(e -> trySaving());

		buttons.put("new", newButton);
		buttons.put("back", backButton);
		buttons.put("open", openButton);
		buttons.put("next", nextButton);
		buttons.put("save", saveButton);
	}

	protected void reset() {
		service.reset();
		refresh();
		setFocus();
	}

	private void tryPrevious() {
		try {
			loadPrevious();
		} catch (Exception e) {
			e.printStackTrace();
			error.message(e.getMessage()).stage(this).showAndWait();
		}
	}

	private void loadPrevious() throws ResourceAccessException, InvalidException, NotFoundException {
		((Spun) service).previous();
		refresh();
		setFocus();
	}

	private void tryOpening() {
		Long id = getId();
		if (id != null)
			tryGetting(id);
	}

	private Long getId() {
		openDialog.showAndWait();
		return openDialog.getId();
	}

	private void tryGetting(Long id) {
		try {
			showFound(id);
		} catch (Exception e) {
			e.printStackTrace();
			error.message(e.getMessage()).stage(this).showAndWait();
		}
	}

	private void showFound(Long id) {
		service.set(service.find(id));
		refresh();
		setFocus();
	}

	private void tryNext() {
		try {
			showNext();
		} catch (Exception e) {
			e.printStackTrace();
			error.message(e.getMessage()).stage(this).showAndWait();
		}
	}

	private void showNext() throws ResourceAccessException {
		((Spun) service).next();
		refresh();
		setFocus();
	}

	private void trySaving() {
		try {
			save();
			info.message("Successfully posted data of\n" + getModule() + ": " + service.getId()).stage(this)
					.showAndWait();
			refresh();
		} catch (ResourceAccessException e) {
			error.message("Data NOT posted;\nNo server connection;\ncheck network").stage(this).showAndWait();
			e.printStackTrace();
		} catch (HttpClientErrorException e) {
			if (e.getResponseBodyAsString().contains("This connection has been closed"))
				error.message("Data NOT posted\nDatabase stopped;\nreboot server").stage(this).showAndWait();
			e.printStackTrace();
		}
	}

	@Override
	protected void addFooter(VBox box) {
		setUserBox();
		box.getChildren().addAll(addSummaryBox(), userHBox);
	}

	protected void setUserBox() {
		userHBox = new HBox(addEncoderNodes());
		setHBoxProperties(userHBox);
	}

	private Node[] addEncoderNodes() {
		Label encoderLabel = new Label("Created by");
		encoderDisplay = new UserDisplay("");
		Label timestampLabel = new Label("on");
		timestampDisplay = new TimestampDisplay(null);
		return new Node[] { encoderLabel, encoderDisplay, timestampLabel, timestampDisplay };
	}

	protected void setHBoxProperties(HBox hBox) {
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(0, 10, 10, 10));
		hBox.setAlignment(Pos.CENTER);
	}

	private HBox addSummaryBox() {
		HBox summaryBox = new HBox(addSummaryNodes());
		setHBoxProperties(summaryBox);
		return summaryBox;
	}

	protected Node[] addSummaryNodes() {
		return new Node[] {};
	};

	@Override
	protected String getTitleName() {
		return service.getId() == null ? newModule() : moduleId();
	}

	private String newModule() {
		return "New " + abbr;
	}

	protected String moduleId() {
		return "[" + abbr + " No. " + service.getId() + " ]";
	}
}
