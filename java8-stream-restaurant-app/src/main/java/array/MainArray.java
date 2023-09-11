package array;

import java.util.ArrayList;
import java.util.Arrays;

public class MainArray {


    public static void main(String... args) {

        Integer [] arr1 = new Integer[]{ 1, 2,10,22,25,30,40, 60 , 80};
        Integer [] arr2 = new Integer[] {3,5,7,13,26};

        // Merge two array into once arr3, return
         /*
            ArrayList<Integer> arrInt = ...;
            arrInt.add(arr1);
            arrInt.add(arr2);
           // arrInt has all elements of tow arr1 and arr2 | 1, 2,10,22,25,30,40, 60 , 80, 3,5,7,13,26
           arrInt.sort(// Condition);  // 1, 2, 3, 5, 7, 10, 13, 25, 26.... 80
           int [] arrResult =  arrtInt.stream().mapInt(Integer::value).toArray();

          */

        // Actual implementation
        ArrayList<Integer> arrInt = new ArrayList<>(); // Default is 10 elements
        arrInt.addAll(Arrays.asList(arr1));
        arrInt.addAll(Arrays.asList(arr2));

        int[] arrResult =  arrInt.stream().sorted().mapToInt(a -> a).toArray();   // Integer -> int, stream(.. 1 , 2  )
        for (int i = 0; i < arrResult.length; i++) {
            System.out.println(arrResult[i]);
        }

    }



    /*
    Ways to init array.
    int[] myIntArray = new int[3]; // each element of the array is initialised to 0
    int[] myIntArray = {1, 2, 3};
    int[] myIntArray = new int[]{1, 2, 3};

    int [] myIntArray = IntStream.range(0, 100).toArray(); // From 0 to 99
    int [] myIntArray = IntStream.rangeClosed(0, 100).toArray(); // From 0 to 100
    int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).toArray(); // The order is preserved.
    int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // Sort

    */
}
