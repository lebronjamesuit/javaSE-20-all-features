package apple;

public class AppleHeavy implements ApplePredicate {
    public boolean checkIfMatch(Apple a) {
        return a.getWeight() > 150;
    }
}
