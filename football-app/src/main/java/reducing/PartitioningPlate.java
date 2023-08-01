package reducing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class PartitioningPlate {
    public static void main(String... args) {
        System.out.println("Dishes partitioned by vegetarian: " + partitionByVegeterian());
        System.out.println("Dishes partitioned by greater 400: " + partitionByHighLowCalories());
        System.out.println("Vegetarian Plates by type: " + vegetarianPlatesByType());
        System.out.println(" Divide by Vegetarian, then Type Plates  : " + devideByVegetarianAndByType());
    }


    public static Map<Boolean, List<Plate>> partitionByVegeterian() {
        return Plate.menu.stream().collect(Collectors.partitioningBy(plate -> plate.isVegetarian()));
    }

    public static Map<Boolean, List<Plate>> partitionByHighLowCalories() {
        return Plate.menu.stream().collect(Collectors.partitioningBy(plate -> plate.getCalories() > 400));
    }

    public static Map<Plate.Type, List<Plate>> vegetarianPlatesByType() {
        return Plate.menu.stream()
                .filter(plate -> plate.isVegetarian())
                .collect(Collectors.groupingBy(Plate::getType));
    }

    public static Map<Boolean, Map<Plate.Type, List<Plate>>> devideByVegetarianAndByType() {
        return Plate.menu.stream().collect(
                partitioningBy(
                        plate -> plate.isVegetarian() == true,
                        groupingBy(Plate::getType)
                )
        );
    }

}
