package pizzarestaurant.applysolid;

import pizzarestaurant.applysolid.factory.PizzaFactoryInterface;
import pizzarestaurant.applysolid.typeofpizza.AbstractPasta;
import pizzarestaurant.applysolid.typeofpizza.AbstractPizza;

public class RestaurantOrderManagement {

    public AbstractPizza orderingPizza(PizzaFactoryInterface pizzaFactoryInterface) {

        AbstractPizza pizza = pizzaFactoryInterface.createPizza();
        pizza.makePizzaByProcess();
        return pizza;
    }

    public AbstractPasta orderingPasta (){
        // To do, extend later
        return null;
    }

}
