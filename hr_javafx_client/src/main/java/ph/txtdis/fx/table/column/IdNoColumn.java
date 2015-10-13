package ph.txtdis.fx.table.column;

public abstract class IdNoColumn<S> extends AbstractColumn<S, Long> {

    public IdNoColumn(String name, String id) {
        super(name, id, 50);
    }
}
