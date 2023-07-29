package customefunctional;


import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReturnFunctionTest {

    @Test
    public void testNumberOfAGivenCharInAString() {

        // Given count how many T char in that
        ReturnFunction returnFunction = (t) -> {
            String s = (String) t;
            return s.chars().filter(i -> i == 't').count();

        };

        // Then
        assertEquals(Long.valueOf(2),returnFunction.accept("the end of the world") );
    }
}
