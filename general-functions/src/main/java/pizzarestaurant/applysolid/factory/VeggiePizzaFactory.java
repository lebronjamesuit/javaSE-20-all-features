package pizzarestaurant.applysolid.factory;

import pizzarestaurant.applysolid.typeofpizza.AbstractPizza;
import pizzarestaurant.applysolid.typeofpizza.VeggiePizza;

public class VeggiePizzaFactory implements PizzaFactoryInterface {
    @Override
    public AbstractPizza createPizza() {
        return new VeggiePizza();
    }
}
