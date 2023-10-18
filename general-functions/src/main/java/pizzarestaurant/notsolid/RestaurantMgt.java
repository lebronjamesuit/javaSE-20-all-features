package pizzarestaurant.notsolid;

import pizzarestaurant.notsolid.factory.PizzaFactory;
import pizzarestaurant.notsolid.typeofpizza.AbstractPizza;

import java.lang.reflect.InvocationTargetException;


public class RestaurantMgt {

    public  AbstractPizza orderingAllPizza(String className) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        PizzaFactory factory =  new PizzaFactory() ;
        AbstractPizza abstractPizza =  factory.factoryPizzaGeneral("pizzarestaurant.notsolid.typeofpizza."+className);
        return abstractPizza;
    }

}
