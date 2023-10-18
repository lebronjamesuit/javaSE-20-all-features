package pizzarestaurant.applysolid.typeofpizza;

import pizzarestaurant.applysolid.factory.AdditionalBakeAction;


public class BBQPizza extends AbstractPizza implements AdditionalBakeAction {
    public BBQPizza() {
        name = "I'm BBQ Pizza, new commer";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare BBQPizza");
    }

    @Override
    public void bakePizza() {
        System.out.println("baking for BBQPizza");
    }

    @Override
    public void cutPizza() {
        System.out.println("cutting for BBQPizza");
    }


    // Implement from AdditionalBakeAction
    public void addSauce() {
        System.out.println("Add Sauce BBQPizza");
    }

    public void addTopping() {
        System.out.println("Add Topping for BBQPizza");
    }

}
