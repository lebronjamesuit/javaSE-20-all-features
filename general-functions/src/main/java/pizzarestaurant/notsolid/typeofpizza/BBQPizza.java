package pizzarestaurant.notsolid.typeofpizza;

//// This class is added later to the exising system
public class BBQPizza extends AbstractPizza {

    public BBQPizza() {
        name  = "name is BBQPizza";
    }

    @Override
    public void prepareBake() {
        System.out.println( this.getClass().toString() +  " prepareBake");
    }

    @Override
    public void addSauce() {
        System.out.println( this.getClass().toString() +  " addSauce");
    }

    @Override
    public void addTopping() {
        System.out.println( this.getClass().toString() +  " addTopping");
    }

    @Override
    public void bakePizza() {
        System.out.println( this.getClass().toString() +  " bakePizza");
    }

    @Override
    public void cutPizza() {
        System.out.println( this.getClass().toString() +  " cutPizza");
    }
}
