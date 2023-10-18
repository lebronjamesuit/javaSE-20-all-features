package Arrays;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JoinArray {

    public static void main(String... args) throws IOException {

        int[] arrayInt1 = new int[]{1 ,3 , 6, 7, 10, 23, 50, 77, 100} ;
        int[] arrayInt2 = new int[]{5 ,4 , 11, 8, 44, 79, 102} ;

        int [] joinArray = joinArrayAndSort(arrayInt1, arrayInt2);
    }

    private static int[] joinArrayAndSort(int[] arrayInt1, int[] arrayInt2) {

        // create new array with size = arrayINt1.size + arrauInt2.size ; 9 + 7 = 16;
        // array3.add (array 1)
        // array3.add (array 2)
        // use Quick Sort on the size of 16.

               // 1 ,3 , 6, 7, 10, 23, 50, 77, 100   5 ,4 , 11, 8, 44, 79, 102
        // index  0  1   2  3  4   5   6   7   8     9  10  11  12 13  14  15
        // mid-index = Round(16 /2) =  8
        // pick the pivot = last-Element = 102, startIndex = 0,
        // write partionMethod to return pIndex, select pivot, push element which has smaller pivot
        // to the left.

        int size = arrayInt1.length + arrayInt2.length;
        int [] arr3 = new int[size];

        int k = 0;
        for (int i = 0; i < arrayInt1.length; i++) {
            arr3[i] = arrayInt1[i];
            k = i;
        }
        k++;
        for (int j = 0; j < arrayInt2.length; j++) {
            arr3[k+j] = arrayInt2[j];
        }

        Arrays.stream(arr3).forEach(System.out::println);

        sortThisArray(arr3);
        return arr3;

    }

    private static void sortThisArray(int[] arr3) {
         quickSort(arr3, 0, arr3.length-1);

        // 1 ,3 , 6, 7, 10, 23, 50, 77, 100   5 ,4 , 11, 8, 44, 79, 102  // size = 16
    }

    private static void quickSort(int[] arr3, int start, int end) {

        int pIndex = partitionArray(arr3, start, end);
        quickSort(arr3, start, pIndex - 1);
        quickSort(arr3, pIndex+1 , end);

        // pIndex =

    }

    private static int partitionArray(int[] arr3, int start, int end) {
        int pivot = arr3[end];

        return 0;
    }


}
