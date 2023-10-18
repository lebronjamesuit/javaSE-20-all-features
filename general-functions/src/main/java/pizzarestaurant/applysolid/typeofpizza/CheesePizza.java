package pizzarestaurant.applysolid.typeofpizza;

import pizzarestaurant.applysolid.factory.AdditionalBakeAction;

public class CheesePizza extends AbstractPizza implements AdditionalBakeAction {

    public CheesePizza() {
        name = "Cheese";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare CheesePizza");
    }

    @Override
    public void bakePizza() {
        System.out.println("baking for CheesePizza");
    }

    @Override
    public void cutPizza() {
        System.out.println("cutting for CheesePizza");
    }

    // Interface
    public void addSauce() {
        System.out.println("Add Sauce CheesePizza");
    }
    public void addTopping() {
        System.out.println("Add Topping for CheesePizza");
    }
}
