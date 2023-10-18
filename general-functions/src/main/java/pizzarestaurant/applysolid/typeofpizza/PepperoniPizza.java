package pizzarestaurant.applysolid.typeofpizza;

import pizzarestaurant.applysolid.factory.AdditionalBakeAction;

public class PepperoniPizza extends AbstractPizza implements AdditionalBakeAction {
    public PepperoniPizza() {
        name = "Pepperoni";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare PepperoniPizza");
    }

    @Override
    public void bakePizza() {
        System.out.println("baking for PepperoniPizza");
    }

    @Override
    public void cutPizza() {
        System.out.println("cutting for PepperoniPizza");
    }

    // Interface
    public void addSauce() {
        System.out.println("Add Sauce PepperoniPizza");
    }
    public void addTopping() {
        System.out.println("Add Topping for PepperoniPizza");
    }

}
