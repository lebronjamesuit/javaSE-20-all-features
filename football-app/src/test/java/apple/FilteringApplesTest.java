package apple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FilteringApplesTest {

    List<Apple> inventory = null;

    @BeforeEach
    public void init() {
        inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(140, "pink"),
                new Apple(120, "half orange"),
                new Apple(120, "red"));
    }

    @Test
    public void filterRedApple() {
        List<Apple> apples = FilteringApples.filterWithPredicate(inventory, new AppleRedColorPredicate());

        Assertions.assertEquals(1, apples.size());
        Assertions.assertEquals("red", apples.get(0).getColor());
    }

    @Test
    public void filterHeavyApple() {
        List<Apple> apples = FilteringApples.filterWithPredicate(inventory, new AppleHeavy());
        Assertions.assertEquals(1, apples.size());
        Assertions.assertEquals(155, apples.get(0).getWeight());
    }

}
