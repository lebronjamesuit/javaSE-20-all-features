import java.io.IOException;
import java.util.Arrays;

public class SortArray {


    public static void main(String... args) throws IOException {

         // 7 2 1 6 8 5 3 4
        Integer [] arrInt = new Integer[]{7,2,1,6,8,5,3,4};
        selectionSort(arrInt);
      //  Arrays.stream(arrInt).forEach(System.out::println);

        Integer [] arrayInteger2 = new Integer[]{7,2,1,6,8,5,3,4};
        bubbleSort(arrayInteger2);
        Arrays.stream(arrayInteger2).forEach(System.out::println);
    }

   /*  Selection Sort: run a double for loop to iterate array a size 8,
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


    public static Integer [] selectionSort(Integer [] a) {
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

    public static Integer [] bubbleSort(Integer [] a) {
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



}


