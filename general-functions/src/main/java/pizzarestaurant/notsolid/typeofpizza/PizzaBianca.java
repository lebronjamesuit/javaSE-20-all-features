package pizzarestaurant.notsolid.typeofpizza;


/*
The Boss wants to have pizza bianca, because it has no sauce
How does it fit into the system
 */

public class PizzaBianca extends AbstractPizza{

    public PizzaBianca() {
        name = "I'm PizzaBianca, new commer";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare PizzaBianca");
    }

    // If we keep this class, It's violated Liskov, subclass cannot substitute for abstract class.
    @Override
    public void addSauce()  {
        System.out.println("THROW EXCEPTION - WARRNING - This pizza don't have sauce");
    }

    @Override
    public void addTopping() {
        System.out.println("Add Topping for PizzaBianca");
    }

    @Override
    public void bakePizza() {
        System.out.println("baking for PizzaBianca");
    }

    @Override
    public void cutPizza() {
        System.out.println("cutting for PizzaBianca");
    }
}
