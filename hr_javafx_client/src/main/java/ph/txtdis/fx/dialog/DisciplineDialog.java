package ph.txtdis.fx.dialog;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ph.txtdis.dto.Discipline;
import ph.txtdis.fx.datepicker.IncidenceDatePicker;
import ph.txtdis.fx.field.AllegationField;
import ph.txtdis.fx.input.InputNode;
import ph.txtdis.service.HumanResourceService;

@Component
public class DisciplineDialog extends
        FieldDialog<Discipline, HumanResourceService>implements
        Inputted<Discipline> {

    @Autowired
    private IncidenceDatePicker incidenceDatePicker;

    @Autowired
    private AllegationField allegationField;

    public DisciplineDialog() {
        super("Disciplinary Action");
    }

    @Override
    protected List<InputNode<?>> addNodes() {
        return Arrays.asList(incidenceDatePicker, allegationField);
    }

    @Override
    protected Discipline createEntity() {
        return new Discipline(incidenceDatePicker.getValue(), allegationField
                .getValue());
    }
}
