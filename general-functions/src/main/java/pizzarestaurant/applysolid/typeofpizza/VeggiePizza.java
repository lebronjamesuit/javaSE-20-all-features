package pizzarestaurant.applysolid.typeofpizza;

import pizzarestaurant.applysolid.factory.AdditionalBakeAction;

public class VeggiePizza extends AbstractPizza implements AdditionalBakeAction {
    public VeggiePizza() {
        name = "Veggie";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare VeggiePizza");
    }

    @Override
    public void bakePizza() {
        System.out.println("baking for VeggiePizza");
    }

    @Override
    public void cutPizza() {
        System.out.println("cutting for VeggiePizza");
    }

    // Interface
    public void addSauce() {
        System.out.println("Add Sauce VeggiePizza");
    }
    public void addTopping() {
        System.out.println("Add Topping for VeggiePizza");
    }
}
