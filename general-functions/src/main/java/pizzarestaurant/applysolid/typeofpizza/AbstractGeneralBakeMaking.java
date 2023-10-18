package pizzarestaurant.applysolid.typeofpizza;

/*
    Template Design Pattern
     The Dependency inversion principle: "Depend upon abstractions, [not] concretions.
     PizzaMainStore.class call PizzaAbstract.makePizzaByProcess() do follow series of steps
     by template.
*/

public abstract class AbstractGeneralBakeMaking {

    protected abstract void prepareBake();

   /*  addTopping is violated Liskov in SOLID
       protected abstract void addTopping();
   */

    public final void makeBakeByProcess() {
        prepareBake();

      /*   violated Liskov
          addSauce();
          addTopping();
       */
    }

}
