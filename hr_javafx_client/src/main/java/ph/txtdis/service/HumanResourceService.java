package ph.txtdis.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ph.txtdis.dto.Assignment;
import ph.txtdis.dto.Audited;
import ph.txtdis.dto.Compensation;
import ph.txtdis.dto.Discipline;
import ph.txtdis.dto.Education;
import ph.txtdis.dto.Employee;
import ph.txtdis.dto.EmployeeAddress;
import ph.txtdis.dto.EmployeeContactInfo;
import ph.txtdis.dto.Family;
import ph.txtdis.dto.GovtId;
import ph.txtdis.dto.Leave;
import ph.txtdis.dto.Loan;
import ph.txtdis.dto.PastWork;
import ph.txtdis.exception.NotFoundException;
import ph.txtdis.type.CivilStatus;
import ph.txtdis.type.FamilyType;

@Service
public class HumanResourceService extends AbstractSpunService<Employee, Long>
		implements Audited, Searched<Employee>, Serviced<Employee, Long>, Spun
{

	private Employee employee;

	private ObservableList<Employee> list;

	@Autowired
	private EmployeeService employeeService;

	public HumanResourceService() {
		reset();
	}

	@Override
	public void reset() {
		this.employee = new Employee();
	}

	@Override
	public ObservableList<Employee> getSearchResult() {
		return FXCollections.observableList(list);
	}

	public void setList(ObservableList<Employee> list) {
		this.list = list;
	}

	public ObservableList<EmployeeAddress> getAddresses() {
		return employee.getAddresses() == null ? null : FXCollections.observableList(employee.getAddresses());
	}

	public void setAddresses(ObservableList<EmployeeAddress> addresses) {
		employee.setAddresses(addresses);
	}

	public ObservableList<EmployeeContactInfo> getContactInfo() {
		return employee.getContactInfo() == null ? null : FXCollections.observableList(employee.getContactInfo());
	}

	public void setContactInfo(ObservableList<EmployeeContactInfo> contactInfo) {
		employee.setContactInfo(contactInfo);
	}

	public ObservableList<GovtId> getGovtIds() {
		return employee.getGovtIds() == null ? null : FXCollections.observableList(employee.getGovtIds());
	}

	public void setGovtIds(ObservableList<GovtId> govtIds) {
		employee.setGovtIds(govtIds);
	}

	public ObservableList<Family> getRelatives() {
		return employee.getRelatives() == null ? null : FXCollections.observableList(employee.getRelatives());
	}

	public void setRelatives(ObservableList<Family> relatives) {
		employee.setRelatives(relatives);
	}

	public ObservableList<Education> getStudies() {
		return employee.getStudies() == null ? null : FXCollections.observableList(employee.getStudies());
	}

	public void setStudies(ObservableList<Education> studies) {
		employee.setStudies(studies);
	}

	public ObservableList<PastWork> getPastJobs() {
		return employee.getPastJobs() == null ? null : FXCollections.observableList(employee.getPastJobs());
	}

	public void setPastJobs(ObservableList<PastWork> pastJobs) {
		employee.setPastJobs(pastJobs);
	}

	public ObservableList<Assignment> getAssignments() {
		return employee.getAssignments() == null ? null : FXCollections.observableList(employee.getAssignments());
	}

	public void setAssignments(ObservableList<Assignment> assignments) {
		employee.setAssignments(assignments);
	}

	public ObservableList<Compensation> getDailyRates() {
		return employee.getDailyRates() == null ? null : FXCollections.observableList(employee.getDailyRates());
	}

	public void setDailyRates(ObservableList<Compensation> dailyRates) {
		employee.setDailyRates(dailyRates);
	}

	public ObservableList<Leave> getLeaves() {
		return employee.getLeaves() == null ? null : FXCollections.observableList(employee.getLeaves());
	}

	public void setLeaves(ObservableList<Leave> leaves) {
		employee.setLeaves(leaves);
	}

	public ObservableList<Loan> getLoans() {
		return employee.getLoans() == null ? null : FXCollections.observableList(employee.getLoans());
	}

	public void setLoans(ObservableList<Loan> loans) {
		employee.setLoans(loans);
	}

	public ObservableList<Discipline> getDisciplinaryActions() {
		return employee.getDisciplinaryActions() == null ? null
				: FXCollections.observableList(employee.getDisciplinaryActions());
	}

	public void setDisciplinaryActions(ObservableList<Discipline> disciplinaryActions) {
		employee.setDisciplinaryActions(disciplinaryActions);
	}

	@Override
	public Employee find(Long id) throws ResourceAccessException {
		Employee e = employeeService.find(id);
		if (e == null)
			throw new NotFoundException("Employee No. " + id);
		return e;
	}

	@Override
	public ObservableList<Employee> search(String name) throws ResourceAccessException {
		return list = FXCollections.observableList(employeeService.search(name));
	}

	@Override
	public Employee get() {
		return employee;
	}

	@Override
	public void set(Employee entity) {
		this.employee = entity;
	}

	@Override
	public Long getId() {
		return employee.getId();
	}

	@Override
	public void setId(Long id) {
		employee.setId(id);
	}

	@Override
	public void save() throws ResourceAccessException {
		set(employeeService.save(employee));
	}

	public String getSurname() {
		return employee.getSurname();
	}

	public void setSurname(String surname) {
		employee.setSurname(surname);
	}

	public String getName() {
		return employee.getName();
	}

	public void setName(String name) {
		employee.setName(name);
	}

	public String getMiddleInitial() {
		return employee.getMiddleInitial();
	}

	public void setMiddleInitial(String middleInitial) {
		employee.setMiddleInitial(middleInitial);
	}

	public LocalDate getBirthdate() {
		return employee.getBirthDate();
	}

	public void setBirthdate(LocalDate birthdate) {
		employee.setBirthDate(birthdate);
	}

	public String getBirthplace() {
		return employee.getBirthplace();
	}

	public void setBirthplace(String birthplace) {
		employee.setBirthplace(birthplace);
	}

	public CivilStatus getCivilStatus() {
		return employee.getCivilStatus();
	}

	public void setCivilStatus(CivilStatus civilStatus) {
		employee.setCivilStatus(civilStatus);
	}

	public String getEmergencyContact() {
		return employee.getEmergencyContact();
	}

	public void setEmergencyContact(String emergencyContact) {
		employee.setEmergencyContact(emergencyContact);
	}

	public FamilyType getEmergencyRelation() {
		return employee.getEmergencyRelation();
	}

	public void setEmergencyRelation(FamilyType emergencyRelation) {
		employee.setEmergencyRelation(emergencyRelation);
	}

	public String getEmergencyPhone() {
		return employee.getEmergencyPhone();
	}

	public void setEmergencyPhone(String emergencyPhone) {
		employee.setEmergencyPhone(emergencyPhone);
	}

	@Override
	public String getCreatedBy() {
		return employee.getCreatedBy();
	}

	@Override
	public ZonedDateTime getCreatedOn() {
		return employee.getCreatedOn();
	}

	@Override
	public void previous() throws ResourceAccessException {
		setNonNull(employeeService.previous(employee.getId()));
	}

	@Override
	public void next() throws ResourceAccessException {
		setNonNull(employeeService.next(employee.getId()));
	}

	private void setNonNull(Employee employee) {
		if (employee != null)
			set(employee);
	}

	public byte[] getPhoto() {
		return employee.getPhoto();
	}

	public void setPhoto(byte[] photo) {
		employee.setPhoto(photo);
	}
}
