package apple;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {

    public static List<Apple> filterWithPredicate(List<Apple> apples, ApplePredicate predicate) {
        // Runtime will depend on which predicate you passed in, we are flexible.
        List<Apple> applesReturn = new ArrayList<>();
        for (Apple a : apples) {
            if (predicate.checkIfMatch(a)) {
                applesReturn.add(a);
            }
        }
        return applesReturn;
    }

}
