package dish;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class DishServiceTest {


    @Test
    public void dishServiceLowCaloriesTest(){

        // Given
        List<String> listExpected = Arrays.asList("season fruit","rice","chicken","prawns");

        // when
        List<String> dishLowCalories = DishesService.getLowCaloricDishesNames(Dish.menu, 400);

        // then
        Assertions.assertEquals(listExpected ,dishLowCalories);

    }


}
