package pizzarestaurant.applysolid.factory;

import pizzarestaurant.applysolid.typeofpizza.AbstractPizza;
import pizzarestaurant.applysolid.typeofpizza.CheesePizza;

public class CheesePizzaFactory implements PizzaFactoryInterface {

    @Override
    public AbstractPizza createPizza() {
        return new CheesePizza();
    }
}
