package ph.txtdis.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ph.txtdis.type.FamilyType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Family extends AbstractAuditedNumbered {

    private FamilyType type;

    private String surname;

    private String name;

    private LocalDate birthDate;

    private String institution;

    private String designation;
}
