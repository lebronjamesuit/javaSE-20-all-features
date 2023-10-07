package Speed;


import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BigDataArray {

    public static void main(String[] args) throws IOException {

       /*
        Write a horrible algorithm that takes  O (n*n*n), uncomment to test it

       Random rd = new Random(); // creating Random object
        int[] arr = new int[10000];  // 1.000 * 1000 * 1000 = 1.000.000.000 Operation
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
          //  System.out.println(arr[i]); // printing each array element
        }
        countingHorribleWay(arr);
        */

        int[] arr = new int[] {-4, 7, 8, 1, 9, 10, 11, 17, 20, 24, 3, -10, -12, -9};
        List<List<Integer>> listResult  = findTripletsWithZeroSum(arr);
        listResult.stream().forEach(System.out::println);


        // Experiment 3: Test with 100 Million Elements in the array
        Random rd = new Random(); // creating Random object
        int[] arrBig = new int[100000000];  // 100.000.000  -> O(n log n) = 100 Million * 26  = 2,6 Billion operation
        for (int i = 0; i < arr.length; i++) {
            arrBig[i] = rd.nextInt();
        }
        findTripletsWithZeroSumPerformanceCheck(arrBig);
    }

    // O(n logn) + O (n) = O (n log n)
    public static  Duration findTripletsWithZeroSumPerformanceCheck(int [] numberArray) {
        Instant starts = Instant.now();
        System.out.println("Time before  countingFasterPerformance " + starts);
        Arrays.sort(numberArray);  // O(n log n);

        int sizeArr = numberArray.length -1;
        for (int i = 0; i < sizeArr -1 ; i++) {    // O(n);
            int j = i + 1;  // Next element of the current pA
            int y = sizeArr -1;  // Always start with the last element in the array.
            while ( j <  y){
                int sumThreeNumbers = numberArray[i] + numberArray[j] + numberArray[y];
                if(sumThreeNumbers == 0 ){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(numberArray[i]);  triplet.add(numberArray[j]);  triplet.add(numberArray[y]);
                    j = y; // break the while
                }else if (sumThreeNumbers >0){
                    y--; // Move pointer toward the left where there is more - value
                } else {
                    j ++; // Move pointer toward the left where there is more + value
                }
            }
        }  // end for

        Instant ends = Instant.now();
        System.out.println("Time after countingFasterPerformance " +ends);
        System.out.println("Duration  " + Duration.between(starts, ends));
        return Duration.between(starts, ends);
    }

    public static  List<List<Integer>> findTripletsWithZeroSum(int [] numberArray) {
        List<List<Integer>> listSumInt = new ArrayList<>();
        Arrays.sort(numberArray);  // O(n log n);
        Arrays.stream(numberArray).forEach(System.out::println);
        int sizeArr = numberArray.length -1;
        for (int i = 0; i < sizeArr -1 ; i++) {    // O( n * n);
         
            // Declare pointers on the left which is A ; B and Y will the rest of array.
            int j = i + 1;
            int y = sizeArr -1;  // y start from index position at the end.

            // 2 pointers will narrow the array.
            while ( j <  y){
                int sumThreeNumbers = numberArray[i] + numberArray[j] + numberArray[y];
                System.out.println(" sumThreeNumbers " + sumThreeNumbers);
                if(sumThreeNumbers == 0 ){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(numberArray[i]);  triplet.add(numberArray[j]);  triplet.add(numberArray[y]);
                    listSumInt.add(triplet);
                    j = y; // break the while
                }else if (sumThreeNumbers >0){
                    y--; // Move pointer toward the left where there is more - value
                    System.out.println(" Pointer py has moved to the position" + y);
                } else {
                    j ++; // Move pointer toward the left where there is more + value
                    System.out.println(" Pointer pb has moved to the position " + j);
                }
            }
        }  // end for
        System.out.println("Found numbers of pair is " + listSumInt.size());
        return listSumInt;

    }

 /*   // n = 5000 , Big(n*n*n) = 5.000.000.000 operation , Duration: 30 seconds
// n 10000 ,  Big(n3)  = 10 billion operation , Duration >4 minutes  */
    public static void countingHorribleWay(int[]  arr){
        Instant starts = Instant.now();
        System.out.println("Time before " + starts);
        int count = 0 ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length -1; j++) {
                for (int k = j+1; k < arr.length ; k++) {
                        if(arr[i] + arr[j] + arr[k] > 0){
                            count++;
                        }
                }
            }
        }

        Instant ends = Instant.now();
        System.out.println("Time after " +ends);
        System.out.println("Duration  " + Duration.between(starts, ends));
    }
}
