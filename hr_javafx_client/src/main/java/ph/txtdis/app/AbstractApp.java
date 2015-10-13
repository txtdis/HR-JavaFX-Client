package ph.txtdis.app;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ph.txtdis.fx.FontIcon;

public abstract class AbstractApp<E, K> extends Stage implements Apped {

	protected Map<String, Button> buttons;
	protected String module, abbr;

	public AbstractApp(String module, String abbr) {
		this.module = module;
		this.abbr = abbr;
	}

	@Override
	public void start() {
		initialize();
		show();
		setFocus();
	}

	private void initialize() {
		setButtons();
		setStage(placeNodes());
		setBindings();
		setListeners();
	}

	@Override
	public void refresh() {
		setTitle(getTitleName());
		setFocus();
	}

	protected abstract void setBindings();

	protected abstract Node[] addVBoxNodes();

	protected abstract void setListeners();

	protected void setButtons() {
		buttons = new LinkedHashMap<>();
	}

	protected HBox addHeader() {
		return createHeaderBox(createTitle(), createTilePane());
	}

	private Label createTitle() {
		Label text = new Label(module);
		text.setStyle("-fx-font-size: 26pt;");
		return text;
	}

	private TilePane createTilePane() {
		TilePane tile = new TilePane();
		tile.getChildren().addAll(buttons.values());
		tile.setHgap(5);
		tile.setAlignment(Pos.TOP_RIGHT);
		return tile;
	}

	private HBox createHeaderBox(Label text, TilePane tile) {
		HBox hBox = new HBox(text, tile);
		HBox.setHgrow(tile, Priority.ALWAYS);
		hBox.setPadding(new Insets(10, 10, 0, 10));
		return hBox;
	}

	protected void addFooter(VBox box) {
	};

	private VBox placeNodes() {
		VBox box = new VBox(addHeader());
		box.getChildren().addAll(addVBoxNodes());
		addFooter(box);
		return box;
	}

	protected Image icon() {
		return new FontIcon("\ue826", Color.NAVY);
	}

	@Override
	public String getModule() {
		return module;
	}

	private void setStage(VBox box) {
		getIcons().add(icon());
		setTitle(getTitleName());
		setScene(new Scene(box, 1280, 640));
	}

	protected String getTitleName() {
		return getModule();
	}
}
