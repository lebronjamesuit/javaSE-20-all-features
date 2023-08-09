package customefunctional;

import org.junit.jupiter.api.Test;

public class AcceptAnythingTest {

    @Test
    public void testPassLambdaAsStringOperation (){
        // Given
        AcceptAnything able = (msg) -> {
            System.out.println(msg);
        };

        // When
      able.accept("123 goal");
               }

    @Test
    public void testPassLambdaAsNumberOperation(){
       // Given
       AcceptAnything able = (a ) -> {
            if( a instanceof Integer){
                int x =  (Integer) a;
                x = x * 100;
                System.out.println(x);
            }

        };
        able.accept(2);
    }
}
