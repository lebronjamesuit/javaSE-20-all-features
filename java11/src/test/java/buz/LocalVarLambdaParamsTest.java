package buz;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocalVarLambdaParamsTest {

    @interface NonNull {}

    /**
     * It supports annotating a Lambda parameter(s) without having to specify
     * an explicit type (sacrificing type inference).
     */
    @Test
    public void testVarLambdaParamSupportingAnnotatedCompileTimeNullCheck() {
        List<String> inputStrings = List.of("A", "b", "C", "d", "e", "f", "g");
        List<String> strings = inputStrings.stream()
                .map((@NonNull var s) -> s.toLowerCase())
                .collect(Collectors.toList());
        assertEquals(strings.size(), inputStrings.size());
    }

}
