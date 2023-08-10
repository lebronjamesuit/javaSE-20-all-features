package MiniMaxMin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MiniMaxMin {

    public static void main(String[] args) throws IOException {
        List<Integer> arr = Arrays.asList(723532089, 256741038, 623958417, 467905213, 714532089, 938071625, 338071625);
        miniMaxSum(arr);
    }

    public static void miniMaxSum(List<Integer> arr) {
        List<Integer> newArrSorted = arr.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());

        int size = arr.size();
        //The output can be greater than a 32 bit integer, use mapToLong
        long sum = newArrSorted.stream().mapToLong(Integer::longValue).sum();
        long max = sum - newArrSorted.get(0);
        long min = sum - newArrSorted.get(size - 1);
        System.out.println(min + " " + max);

    }
}
