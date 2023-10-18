package pizzarestaurant.applysolid.factory;

import pizzarestaurant.applysolid.typeofpizza.AbstractPizza;
import pizzarestaurant.applysolid.typeofpizza.PepperoniPizza;

public class PepperoniPizzaFactory implements PizzaFactoryInterface {
    @Override
    public AbstractPizza createPizza() {
        return new PepperoniPizza();
    }
}
