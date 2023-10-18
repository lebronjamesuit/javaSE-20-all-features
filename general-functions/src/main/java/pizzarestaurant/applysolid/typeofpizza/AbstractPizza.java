package pizzarestaurant.applysolid.typeofpizza;


public abstract class AbstractPizza extends AbstractGeneralBakeMaking {

    protected String name;

    protected abstract void bakePizza();

    protected abstract void cutPizza();

    public final void makePizzaByProcess() {
        super.makeBakeByProcess();
        bakePizza();
        cutPizza();
    }

}
