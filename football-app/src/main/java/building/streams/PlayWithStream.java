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




    }

}
