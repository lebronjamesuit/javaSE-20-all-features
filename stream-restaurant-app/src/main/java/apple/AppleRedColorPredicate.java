package apple;

public class AppleRedColorPredicate implements ApplePredicate {
    public boolean checkIfMatch(Apple a) {
        return a.getColor().equals("red");
    }
}

