package pizzarestaurant.applysolid.typeofpizza;


// Not use yet, use later
public abstract class AbstractPasta extends AbstractGeneralBakeMaking {

    protected String name;

    protected abstract void bakePasta();

    protected abstract void cutPasta();

    public final void makePastaByProcess() {
        super.makeBakeByProcess();
        bakePasta();
        cutPasta();
    }

}