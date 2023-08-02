package building.streams;

import dish.Dish;

import java.util.stream.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class PlayWithStream {

    public static void main(String...args) {

        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2 , 2 ,2, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);


        // Truncating a stream,  sorted ; then order(2) limit
        List<Dish> dishesLimit2  =
                Dish.menu.stream()
                        .filter(d -> d.getCalories() > 500)
                        .sorted(Comparator.comparingInt(Dish::getCalories))  // remove this to goes from top to down
                        .limit(2)
                        .collect(toList());

        dishesLimit2.forEach(System.out::println);

        // Reduce
        List<Integer> numbersList = Arrays.asList(3,4,5,1,2);
        int sum = numbersList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbersList.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbersList.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);

    }

}
