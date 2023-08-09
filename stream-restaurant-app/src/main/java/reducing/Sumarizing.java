package reducing;


import java.util.Comparator;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.reducing;

public class Sumarizing {

    public static void main(String... args) {
        System.out.println("Nr. of Plates: " + howManyPlates());
        System.out.println("The most caloric Plate is: " + findMostCaloricPlate());
        System.out.println("The most caloric plate by comparator is: " + findMostCaloricPlateUsingComparator());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + averageCaloriesInTheMenu());

    }

    private static long howManyPlates() {
        return Plate.menu.stream().count();
    }

    private static Plate findMostCaloricPlate() {
        return Plate.menu.stream().max(Comparator.comparingInt(Plate::getCalories)).get();
    }

    private static Plate findMostCaloricPlateUsingComparator() {
        Comparator<Plate> plateComparator = Comparator.comparing(Plate::getCalories, Comparator.reverseOrder());
        BinaryOperator<Plate> binaryOperator = BinaryOperator.maxBy(plateComparator);
        return Plate.menu.stream().collect(reducing(binaryOperator)).get();
    }

    private static int calculateTotalCalories() {
        int totalCaloBinaryOperator = Plate.menu.stream().map(Plate::getCalories).reduce(0, (calo1, calo2) -> calo1 + calo2);
        int totalCaloMethodReference = Plate.menu.stream().map(Plate::getCalories).reduce(0, Integer::sum);
        if (totalCaloBinaryOperator == totalCaloMethodReference) {
            return totalCaloBinaryOperator;
        }
        return 0;
    }

    private static long averageCaloriesInTheMenu() {
        long countPlace = howManyPlates();
        long totalCalories = Plate.menu.stream().map(Plate::getCalories).reduce(0, Integer::sum).longValue();

        long avgByStream = Plate.menu.stream().collect(averagingInt(Plate::getCalories)).longValue();

        if (avgByStream == (totalCalories / countPlace)) return avgByStream;
        return 0;
    }

}