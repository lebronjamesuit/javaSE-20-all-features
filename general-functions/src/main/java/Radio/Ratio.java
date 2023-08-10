package Radio;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Ratio {

    public static void main(String[] args) throws IOException {
        List<Integer> arr = Arrays.asList(1, 2, 3, -2, -2, 0);
        plusMinus(arr);
    }

    public static void plusMinus(List<Integer> arr) {
        double size = arr.size();
        double pos = (double) arr.stream().filter(a -> a.intValue() > 0).count();
        double nev =  (double) arr.stream().filter(a -> a.intValue() < 0).count();
        double zeroCount = (double)  arr.stream().filter(a -> a.intValue() == 0).count();

        System.out.format("%.5f", pos/size);
        System.out.println();
        System.out.format("%.5f", nev/size);
        System.out.println();
        System.out.format("%.5f", zeroCount/size);
    }
}
