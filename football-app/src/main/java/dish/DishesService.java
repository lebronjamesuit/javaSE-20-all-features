package dish;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DishesService {

    public static void main(String... args) {
        System.out.println("---");
        getLowCaloricDishesNames(Dish.menu, 400).forEach(System.out::println);

        List<Dish> dishes = getTypeDishes(Dish.menu, Dish.Type.MEAT);
        System.out.println(dishes);
    }

    public static List<String> getLowCaloricDishesNames(List<Dish> menu, int calories) {
        return menu.stream()
                .filter(dish -> dish.getCalories() <= 400)
                .sorted(Comparator.comparingInt(Dish::getCalories))
                .map(dish -> dish.getName())
                .collect(Collectors.toList());
    }


    public static List<Dish> getTypeDishes(List<Dish> menu, Dish.Type type) {
        return menu.stream()
                .filter(dish -> dish.getType().equals(type))
                .sorted(Comparator.comparing(Dish::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }


}
