package pizzarestaurant.applysolid.typeofpizza;


/*
The Boss wants to have pizza bianca, white pizza, because it has NO SAUCE, No Topping
How does it fit into the system
 */

public class PizzaBianca extends AbstractPizza {

    public PizzaBianca() {
        name = "I'm PizzaBianca, new commer";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare PizzaBianca");
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
