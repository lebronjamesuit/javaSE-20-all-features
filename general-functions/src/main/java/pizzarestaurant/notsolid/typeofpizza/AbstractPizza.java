package pizzarestaurant.notsolid.typeofpizza;


public abstract class AbstractPizza {

    String name = "";

    public abstract void prepareBake();

    public abstract void addSauce();

    public abstract void addTopping();

    public abstract void bakePizza();

    public abstract void cutPizza();
}
