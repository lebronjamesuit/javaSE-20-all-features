package pizzarestaurant.notsolid;

import pizzarestaurant.notsolid.typeofpizza.AbstractPizza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class OrderMain {

    /*
        This design makes the client code much more difficult to change, and the library code
        is much more simple. The goal in enterprise application is to make client code
        as simple as possible because client code would have 100 - 300 times much more classes than
        library code.
    */


    public static void main(String... args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        RestaurantMgt mgt = new RestaurantMgt();
        AbstractPizza abstractPizza =  mgt.orderingAllPizza("BBQPizza");

        abstractPizza.bakePizza();
        abstractPizza.prepareBake();
        abstractPizza.bakePizza();
        abstractPizza.cutPizza();

        abstractPizza =  mgt.orderingAllPizza("CheesePizza");
        abstractPizza.bakePizza();
        abstractPizza.prepareBake();
        abstractPizza.bakePizza();
        abstractPizza.cutPizza();

        abstractPizza =  mgt.orderingAllPizza("VeggiePizza");
        abstractPizza.bakePizza();
        abstractPizza.prepareBake();
        abstractPizza.bakePizza();
        abstractPizza.cutPizza();

        abstractPizza =  mgt.orderingAllPizza("PizzaBianca");
        abstractPizza.bakePizza();
        abstractPizza.prepareBake();
        abstractPizza.bakePizza();
        abstractPizza.cutPizza();

    }
}
