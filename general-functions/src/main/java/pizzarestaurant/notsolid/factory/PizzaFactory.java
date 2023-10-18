package pizzarestaurant.notsolid.factory;


import pizzarestaurant.notsolid.typeofpizza.*;

import java.lang.reflect.InvocationTargetException;

public class PizzaFactory {

      public  AbstractPizza factoryPizzaGeneral(String classname)
              throws ClassNotFoundException, InstantiationException,
              IllegalAccessException, NoSuchMethodException,
              InvocationTargetException {

          Class<?> clazz  =  Class.forName(classname);
          Object obj  =  clazz.getDeclaredConstructor().newInstance();

          if(obj instanceof BBQPizza){
              return  (BBQPizza) obj;
          }else if(obj instanceof CheesePizza){
              return  (CheesePizza) obj;
          }else if(obj instanceof PepperoniPizza){
              return  (PepperoniPizza) obj;
          }else if (obj instanceof VeggiePizza){
              return  (VeggiePizza) obj;
          }

          return new PizzaBianca();
      }
}
