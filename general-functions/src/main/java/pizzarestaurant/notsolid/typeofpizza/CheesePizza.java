package pizzarestaurant.notsolid.typeofpizza;

public class CheesePizza extends AbstractPizza {

    public CheesePizza() {
        name = "Cheese";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare CheesePizza");
    }

    @Override
    public void addSauce() {
        System.out.println("Add Sauce CheesePizza");
    }

    @Override
    public void addTopping() {
        System.out.println("Add Topping for CheesePizza");
    }

    @Override
    public void bakePizza() {
        System.out.println("baking for CheesePizza");
    }

    @Override
    public void cutPizza() {
        System.out.println("cutting for CheesePizza");
    }
}
