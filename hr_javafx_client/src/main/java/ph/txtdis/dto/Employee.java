package ph.txtdis.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ph.txtdis.type.CivilStatus;
import ph.txtdis.type.FamilyType;
import ph.txtdis.util.Numeric;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractAuditedNumbered {

    private String surname;

    private String name;

    private String middleInitial;

    private byte[] photo;

    private LocalDate birthDate;

    private String birthplace;

    private CivilStatus civilStatus;

    private String emergencyContact;

    private FamilyType emergencyRelation;

    private String emergencyPhone;

    private List<EmployeeAddress> addresses;

    private List<EmployeeContactInfo> contactInfo;

    private List<GovtId> govtIds;

    private List<Family> relatives;

    private List<Education> studies;

    private List<PastWork> pastJobs;

    private List<Assignment> assignments;

    private List<Compensation> dailyRates;

    private List<Leave> leaves;

    private List<Loan> loans;

    private List<Discipline> disciplinaryActions;

    public Employee(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public String getEmergencyPhone() {
        return Numeric.displayPhone(emergencyPhone);
    }

    @Override
    public String toString() {
        return surname + ", " + name;
    }
}
