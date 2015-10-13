package ph.txtdis.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import ph.txtdis.dto.Employee;
import ph.txtdis.fx.FontIcon;
import ph.txtdis.fx.button.SearchButton;
import ph.txtdis.fx.dialog.EmployeeSearchDialog;
import ph.txtdis.fx.dialog.ErrorDialog;
import ph.txtdis.fx.dialog.FoundEmployeeDialog;
import ph.txtdis.fx.layout.TabBox;
import ph.txtdis.fx.tab.CurrentJobTab;
import ph.txtdis.fx.tab.DisciplineTab;
import ph.txtdis.fx.tab.EducationTab;
import ph.txtdis.fx.tab.FamilyTab;
import ph.txtdis.fx.tab.GovtIdTab;
import ph.txtdis.fx.tab.InputTab;
import ph.txtdis.fx.tab.LeaveLoanTab;
import ph.txtdis.fx.tab.PastWorkTab;
import ph.txtdis.fx.tab.PersonalTab;
import ph.txtdis.service.HumanResourceService;

@Component
public class EmployeeApp extends AbstractIdApp<Employee, HumanResourceService> {

	@Autowired
	private TabBox tabBox;

	@Autowired
	private PersonalTab personal;

	@Autowired
	private GovtIdTab govtId;

	@Autowired
	private FamilyTab family;

	@Autowired
	private EducationTab education;

	@Autowired
	private PastWorkTab pastWork;

	@Autowired
	private CurrentJobTab currentJob;

	@Autowired
	private LeaveLoanTab leaveLoan;

	@Autowired
	private DisciplineTab discipline;

	@Autowired
	private SearchButton searchButton;

	@Autowired
	private EmployeeSearchDialog searchDialog;

	@Autowired
	private FoundEmployeeDialog foundDialog;

	@Autowired
	private ErrorDialog error;

	private List<Tab> tabs;

	public EmployeeApp() {
		super("Employee", "Employee");
	}

	@Override
	protected Image icon() {
		return new FontIcon("\ue811", Color.NAVY);
	}

	@Override
	protected String moduleId() {
		return service.get().toString();
	}

	@Override
	public void refresh() {
		tabs.forEach(t -> ((InputTab) t).refresh());
		super.refresh();
	}

	@Override
	public void setFocus() {
		personal.setFocus();
	}

	@Override
	protected void setButtons() {
		super.setButtons();
		searchButton.setOnAction(e -> openSearchDialog());
		buttons.put("search", searchButton);
	}

	private void openSearchDialog() {
		searchDialog.stage(this).showAndWait();
		String name = searchDialog.getText();
		if (name != null)
			trySearching(name);
	}

	private void trySearching(String name) {
		try {
			search(name);
		} catch (Exception e) {
			e.printStackTrace();
			error.message(e.getMessage()).stage(this).showAndWait();
		}
	}

	private void search(String name) throws ResourceAccessException {
		service.search(name);
		listFoundEntities();
		refresh();
		setFocus();
	}

	public void listFoundEntities() {
		foundDialog.stage(this).showAndWait();
		Employee e = foundDialog.getSelectedItem();
		if (e != null)
			service.set(e);
	}

	@Override
	protected Node[] addVBoxNodes() {
		setTabArray();
		return new Node[] { tabBox.addTabs(tabs) };
	}

	@Override
	protected void setBindings() {
		disableTabsIfEmptyNames();
		disableSavingIfEmptyNames();
	}

	private void disableSavingIfEmptyNames() {
		buttons.get("save").disableProperty().bind(personal.isEmpty());
	}

	private void disableTabsIfEmptyNames() {
		tabs.stream().filter(t -> !t.getId().equals("personal"))
				.forEach(t -> t.disableProperty().bind(personal.isEmpty()));
	}

	private void setTabArray() {
		// @formatter:off
        tabs = Arrays.asList(
                personal.tab(),
                govtId.tab(),
                family.tab(),
                education.tab(),
                pastWork.tab(),
                currentJob.tab(),
                leaveLoan.tab(),
                discipline.tab());
        // @formatter:on
	}

	@Override
	public void save() throws ResourceAccessException {
		tabs.forEach(t -> ((InputTab) t).save());
		service.save();
	}

	@Override
	protected void setListeners() {
		// TODO Auto-generated method stub

	}
}
