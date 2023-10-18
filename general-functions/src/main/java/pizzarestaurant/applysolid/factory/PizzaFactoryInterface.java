package pizzarestaurant.applysolid.factory;

/*
 *  Factory design pattern
 * */

import pizzarestaurant.applysolid.typeofpizza.AbstractPizza;

public interface PizzaFactoryInterface {
    AbstractPizza createPizza();
}
