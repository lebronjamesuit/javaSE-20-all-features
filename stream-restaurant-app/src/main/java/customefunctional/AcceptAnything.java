package customefunctional;

// It's a consumer type

@FunctionalInterface
public interface AcceptAnything<T> {

    void accept(T t);

}
