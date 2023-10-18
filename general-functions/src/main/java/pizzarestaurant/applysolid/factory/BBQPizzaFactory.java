package pizzarestaurant.applysolid.factory;


import pizzarestaurant.applysolid.typeofpizza.AbstractPizza;
import pizzarestaurant.applysolid.typeofpizza.BBQPizza;

// This class is added later to the exising system
public class BBQPizzaFactory implements PizzaFactoryInterface {

    @Override
    public AbstractPizza createPizza() {
        return new BBQPizza();
    }
}
