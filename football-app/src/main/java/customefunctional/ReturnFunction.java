package customefunctional;

// a function type

@FunctionalInterface
public interface ReturnFunction<T, R> {

     R accept(T t);
}
