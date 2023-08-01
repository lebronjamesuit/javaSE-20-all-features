package reducing;

public class ReducingPlate {

    public static void main(String... args) {
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());

    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return Plate.menu.stream().map(Plate::getCalories).reduce(0, Integer::sum).intValue();
    }

}
