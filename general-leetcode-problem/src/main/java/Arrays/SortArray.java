package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class SortArray {

    // Compare the speed of Selection Sort, Bubble Sort and Quick Sort.
    public static void main(String... args) throws IOException {

        System.out.println("Please enter a big numbers from 100.000 to 1.000.000 " );
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size = br.readLine();
        Random random = new Random();
        int arraySize = Integer.parseInt(size);
        int [] randomArrayInt =  new int[arraySize];

        for (int i = 0; i <randomArrayInt.length; i++) {
            randomArrayInt[i] = random.nextInt();
        }

         // Compare
        // size 200.000 , Time: 17 seconds, O(n*n) | 20. 000.000.000 -> 20 Billion Operation
        //   observationSelectionSort(randomArrayInt);

        System.out.println("---------");

        // size 200.000 , Time: 1 minutes 28 seconds, O(n*n)
       // observationBubbleSort(randomArrayInt);

        System.out.println("---------");
        // size 200000 , Time: 0.043562 second = 43 milisecond , O(n log n )
        // https://www.omnicalculator.com/math/log
        // -> n = 200.000 -> O(n logn) = 200.000 * 17.61 = 3.522.000 operations
         observationsQuickSort(randomArrayInt);
    }

    private static void observationBubbleSort(int[] randomArrayInt) {
        //Integer [] arrayInteger2 = new Integer[]{7,2,1,6,8,5,3,4};
        double size = randomArrayInt.length;
        Instant starts = Instant.now();
        System.out.println("Time before " + starts);
        bubbleSort(randomArrayInt);

        Instant ends = Instant.now();
        System.out.println("Time ends " + ends);
        System.out.println("Duration  " + Duration.between(starts, ends));
        System.out.println("BubbleSort  Time complexity is O(n * n)  which n * n = " + Math.pow(size, 2) );
       // Arrays.stream(arrayInteger2).forEach(System.out::println);

    }

    private static void observationSelectionSort(int[] randomArrayInt) {
        //Integer [] arrInt = new Integer[]{7,2,1,6,8,5,3,4};
        double size = randomArrayInt.length;
        Instant starts = Instant.now();
        System.out.println("Time before " + starts);

        selectionSort(randomArrayInt);

        Instant ends = Instant.now();
        System.out.println("Time ends " + ends);
        System.out.println("Duration  " + Duration.between(starts, ends));
        System.out.println("SelectionSort Time complexity is O(n * n)  which n*n = " +  Math.pow(size, 2) );
    }

    private static void observationsQuickSort(int[] randomArrayInt) throws IOException {
        //int [] arrayInteger3 = new int[]{7,2,1,6,8,5,3,4};

        Instant starts = Instant.now();
        System.out.println("Time before " + starts);

        quickSortMyOwn(randomArrayInt);

        Instant ends = Instant.now();
        System.out.println("Time ends " + ends);
        System.out.println("Duration  " + Duration.between(starts, ends));
        System.out.println("Quick sort Time complexity is O(log n)  which n = " + randomArrayInt.length );
        //  Arrays.stream(randomArrayInt).forEach(System.out::println);  // Open this command when array size less than 100
    }

   /*
    Story line

    Selection Sort: run a double for loop to iterate array a size 8,
      Each loop I select the smallest numbers, then push it to the left of the array by
      Swap current index with a[i]. Keep push the smallest element to the left.
      Each loop it solves 1 problem. Remain n-1 problem.

      e.g   7,2,1,6,8,5,3,4
            for
              for
                when i = 0, a[i]= 7 , (j = 1 -> j=7) the smallest = 1, swap(a[i],smallest);
                1 2 7 6 8 3 5 // 1 is the smallest, we solved 1 problem, remain n-1 = 8-1 = 7 problems

       Time complexity is: n + (n-1) + (n-2) ... = n(n-1)/2 = n*n/2 + n/2
       When n is really big like 1000.000. The dominate factor is n*n
       So  O(n*n), it's called big O of n square
       Best case: O(n*n)
       Worst case: O(n*n)
       Average case: O(n*n)

    */

    public static int [] selectionSort(int [] a) {
        for (int i =0 ; i < a.length - 1 ; i++){
            int indexOfSmaller = i;
            int smallest = a[i] ;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < smallest){
                    smallest = a[j];
                    indexOfSmaller = j;
                }
            }
            int tmp = a[i] ;
            a[i] = a[indexOfSmaller];
            a[indexOfSmaller] = tmp;
        }
        return a;
    }

   /*
      bubble sort: run two for loop with index start from 0 to n-1
      compare a[i] > a[i+1], then swap them, push the bigger number to the right as much as possible.
      It's called bubble because whatever numbers are bigger do UP to the right.

      e.g   7,2,1,6,8,5,3,4   Size = 8
            for i = 0 - 6
              for j= 1 - 7
              if(a[i]) > a[j] then swap();
              // 2 1 6 7 8 3 4 5   -> loop i = 0  solve 0 problem
              // 1 2 6 7 3 4 5 8   -> loop i = 1  solve 3 problem for 1; 2; 8
              // 1 2 6 3 4 5 7 8   -> loop i = 2  solve 1 problem for 7
              // 1 2 3 4 5 6 7 8   -> loop i = 4  solve 3 problem for 3 4 5 6
              // 1 2 3 4 5 6 6 8  no swap return done;

        Time complexity: O(n*n)
        Best case: O(n*n)
        Worst case O(n*n)
        Average case 0(n*n)

    */

    public static int [] bubbleSort(int [] a) {
        int size = a.length; // 8
        for (int i = 0; i < size -1 ; i++) {   // i index max = 6
            for (int j = i+1; j < size; j++) {  // j index max = 7
                if(a[i] > a[j]){
                    //swap them
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
        return a;
    }


    private static int [] quickSortMyOwn(int [] arrayA){
     return  quickSortRecursive(arrayA, 0, arrayA.length-1);
    }

    private static int [] quickSortRecursive(int [] arrayA, int start, int end) {
        if(start > end) return arrayA;
        int pIndex = partition(arrayA, start, end);
        quickSortRecursive(arrayA, start, pIndex-1);
        quickSortRecursive(arrayA, pIndex+1, end);

        return arrayA;
    }

    private static int partition(int[] arrA, int start, int end) {
        var pivot  = arrA[end];
        var pIndex = start; // partition index.
        for(var i= start; i < end; i++){  //  do not access pivot element
            if ( arrA[i] < pivot )  {
                //
                swap(arrA, i, pIndex);
                pIndex++;
            }// push it to the left by swap();

        }
        swap(arrA, end, pIndex);
        return pIndex;

    }

    private static void swap(int[] a, int right, int left) {
        int tmp = a[right];
        a[right] = a[left];
        a[left] = tmp;
    }
}

/*Quick Sort: pick a pivot on the right of the array. Do the partitioning for the array
     bigger elements go to the right, smaller elements to the left.
     We got 2 small problems, continue this recursion to divide 2 small problems to 4 small problem
     Device until the smallest acceptable subarray is 2 elements.

     e.g
    a  []  {7,2,1,6,8,5,3,4}   Size = 8
    index   0 1 2 3 4 5 6 7

  After the method partition is called once. the array will be like this
    a  []  {2,1,3, 4 ,8,5,7, 6}   Pivot = 4;
    index   0 1 2  3  4 5 6  7

    i       0 1 2 3 4 5
    pIndex  0 1 2 3

     // start = 0, end = a[size-1];
     partition(a, start, end) {
        pivot  = a[end]; // a[7] = 4
        pIndex = 0; // partition index.
        for(i=0; i < end-1; i++){
          if a[i] < pivot // push it to the left by swap();
            swap(a, a[i], pIndex);
            pIndex++;
        }
        swap(arr, Pindex, PivotIndex);

       return pIndex;
     }


     QuickSoftGeneral(arr, start, end){

      if (start > end )
       int pIndex = partition(arr, start, end);
                     QuickSortGeneral(arr, start, pIndex-1) ; // Left
                     QuickSortGeneral(arr, pIndex+1, end); // right


     }

// Call stack
    I) 2,1,3  call the QuickSoftGeneral(arr, 0, 4);
        2 1 3  (Pivot is 3) run partition method we have
        1 2 3  pIndex = 0;
        Next round  call QuickSoftGeneral (arr, 0, -1) // hit the stop condition.


    arr 1 2 3 4 8,5,7,6
    ix  0 1 2 3 4 5 6 7

        8 5 7 6  call the QuickSoftGeneral(arr, 4, 7); pivot is 6
 state  5 8 7 6
 state  5 6 7 8

     i  4 5 6
 pIndex 4 5    return PIndex = 5;

    *
    * */


