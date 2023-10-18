package pizzarestaurant.notsolid.typeofpizza;

public class VeggiePizza extends AbstractPizza {
    public VeggiePizza() {
        name = "Veggie";
    }

    @Override
    public void prepareBake() {
        System.out.println("Prepare VeggiePizza");
    }

    @Override
    public void addSauce() {
        System.out.println("Add Sauce VeggiePizza");
    }

    @Override
    public void addTopping() {
        System.out.println("Add Topping for VeggiePizza");
    }

    @Override
    public void bakePizza() {
        System.out.println("baking for VeggiePizza");
    }

    @Override
    public void cutPizza() {
        System.out.println("cutting for VeggiePizza");
    }
}
