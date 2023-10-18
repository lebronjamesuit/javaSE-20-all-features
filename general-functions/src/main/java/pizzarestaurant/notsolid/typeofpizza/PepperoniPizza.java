package pizzarestaurant.notsolid.typeofpizza;

public class PepperoniPizza extends AbstractPizza {
    public PepperoniPizza() {
        name = "Pepperoni";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare PepperoniPizza");
    }

    @Override
    public void addSauce() {
        System.out.println("Add Sauce PepperoniPizza");
    }

    @Override
    public void addTopping() {
        System.out.println("Add Topping for PepperoniPizza");
    }

    @Override
    public void bakePizza() {
        System.out.println("baking for PepperoniPizza");
    }

    @Override
    public void cutPizza() {
        System.out.println("cutting for PepperoniPizza");
    }
}
