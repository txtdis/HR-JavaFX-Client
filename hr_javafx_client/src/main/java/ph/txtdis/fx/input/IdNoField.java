package ph.txtdis.fx.input;

import org.springframework.stereotype.Component;

import ph.txtdis.fx.Styled;

@Component
public class IdNoField extends IntegerField {

    public IdNoField() {
        super();
    }

    public IdNoField(Long id) {
        super(id);
    }

    @Override
    public void setLong(Long number) {
        Styled.forIdNo(this, number);
    }

    public Long getIdNo() {
        return getLong();
    }

    public void setIdNo(Long id) {
        setLong(id);
    }
}