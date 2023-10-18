package dto;

import java.sql.Array;
import java.util.*;
import java.util.Properties;
import java.util.stream.Collectors;

public class MainClass {

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



}
