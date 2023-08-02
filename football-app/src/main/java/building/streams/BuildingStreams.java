package building.streams;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String...args) throws Exception{

        // Stream.of
        Stream<String> stream = Stream.of("English", "FootBall", "is", "Great");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Arrays.stream, let's sum it up
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum() ;
        System.out.println(sum);

        // Stream.iterate
        // doc public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) {
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        // Fibonaci
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }

}
