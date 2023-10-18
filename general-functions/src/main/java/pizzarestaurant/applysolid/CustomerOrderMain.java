package pizzarestaurant.applysolid;

import pizzarestaurant.applysolid.factory.BBQPizzaFactory;
import pizzarestaurant.applysolid.factory.BiancaPizzaFactory;
import pizzarestaurant.applysolid.factory.CheesePizzaFactory;
import pizzarestaurant.applysolid.factory.PizzaFactoryInterface;

import java.io.IOException;

public class CustomerOrderMain {


    /*  Hi, I'm the Client, I do not want to know what are you doing inside the library
        to make a pizza. Here is the deal, I would like to order a CheesePizza,
        with in 3 lines of code. Give it to me */
    public static void main(String... args) throws IOException {

        RestaurantOrderManagement restaurantMgt = new RestaurantOrderManagement();
        // Cheese Pizza Waitress take care of it.
        PizzaFactoryInterface factoryInterface = new CheesePizzaFactory();
        restaurantMgt.orderingPizza(factoryInterface);


        // 4 weeks later
        // Boss: I do not want to change the exising system so much, i want to add a new
        // type of pizza every 2 weeks,
        PizzaFactoryInterface bbqFactory = new BBQPizzaFactory();
        restaurantMgt.orderingPizza(bbqFactory);

        // 2 weeks later, add a new Type of Brazilian Pizza.
        // Create new PizzaType and new Factory


        // 8 weeks later, add a new Type of Chinese Pizza.
        // Create new PizzaType and new Factory


        // 10 weeks later, The Boss wants to have pizza bianca, because it has no sauce
        // no topping, just blank pizza.
        PizzaFactoryInterface biancaFactory = new BiancaPizzaFactory();
        restaurantMgt.orderingPizza(biancaFactory);

    }
}
