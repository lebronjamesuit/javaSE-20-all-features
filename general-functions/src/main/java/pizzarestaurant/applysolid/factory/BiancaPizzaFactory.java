package pizzarestaurant.applysolid.factory;

import pizzarestaurant.applysolid.typeofpizza.AbstractPizza;
import pizzarestaurant.applysolid.typeofpizza.PizzaBianca;


public class BiancaPizzaFactory implements PizzaFactoryInterface {

    @Override
    public AbstractPizza createPizza() {
        return new PizzaBianca();
    }
}
