package reducing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Plate {

    public static final List<Plate> menu =
            asList(new Plate("pork", false, 800, Plate.Type.MEAT),
                    new Plate("beef", false, 700, Plate.Type.MEAT),
                    new Plate("chicken", false, 400, Plate.Type.MEAT),
                    new Plate("french fries", true, 530, Plate.Type.OTHER),
                    new Plate("rice", true, 350, Plate.Type.OTHER),
                    new Plate("season fruit", true, 120, Plate.Type.OTHER),
                    new Plate("pizza", true, 550, Plate.Type.OTHER),
                    new Plate("prawns", false, 400, Plate.Type.FISH),
                    new Plate("salmon", false, 450, Plate.Type.FISH));

    public static final Map<String, List<String>> plateTags = new HashMap<>();

    static {
        plateTags.put("pork", asList("greasy", "salty"));
        plateTags.put("beef", asList("salty", "roasted"));
        plateTags.put("chicken", asList("fried", "crisp"));
        plateTags.put("french fries", asList("greasy", "fried"));
        plateTags.put("rice", asList("light", "natural"));
        plateTags.put("season fruit", asList("fresh", "natural"));
        plateTags.put("pizza", asList("tasty", "salty"));
        plateTags.put("prawns", asList("tasty", "roasted"));
        plateTags.put("salmon", asList("delicious", "fresh"));
    }

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Plate(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {MEAT, FISH, OTHER}
}