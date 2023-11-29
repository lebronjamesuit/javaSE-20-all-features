package Arrays;

public class MergeTwoSorted {

    // O(n)
    // This is helper function
    private static int [] mergeTwoArray( int [] arrLeft, int [] arrRight){

        int [] returnArr = new int[arrLeft.length + arrRight.length];
        int index = 0;
        int left = 0 ;
        int right = 0;

        while(left < arrLeft.length && right < arrRight.length){
            if(arrLeft[left] < arrRight[right]){
                returnArr[index] = arrLeft[left];
                index++; left++;
            }else {
                returnArr[index] = arrRight[right];
                index++; right++;
            }
        }

        while(left < arrLeft.length){
            returnArr[index] = arrLeft[left];
            index++;
            left++;
        }

        while(right < arrRight.length){
            returnArr[index] = arrRight[right];
            index++;
            right++;
        }

        return returnArr;

    }

    public static void main(String[] args) {
        int[] arr1 = {1 ,3 ,7, 8 };
        int[] arr2 = { 2, 4, 5, 6};

        // expect two arrays
        int [] returnArr = mergeTwoArray(arr1, arr2);

        System.out.println("Minh");
    }

    /*  What if there is only one array

                 int[] arr1 = {3 ,1 ,7, 8, 2, 5, 6, 4};

    */



}


/* MergeSort
         arrLeft : 1, 3, 7, 8  - sorted
         Index  :  0  1  2  3

         arrRight : 2, 4, 5, 6  - sorted
         Index      0  1  2  3

         new returnArr return array with length = arr1.length + arr2.length
         int i iterate from 0 - mid for the left array
         int j iterate fro  0 - last element for the right array.

         Loop while ( i < arrleft.length() && j < arrRight.length() )
             if   arrLeft[i] < arrRight[j]
                    -> returnArr[index] = arrLeft[i];  index++ i++;
             else
                    -> returnArr[index]=  arrRight[j]; index++ j++;

             returnArr[1, 2, 3 , 4, 5, 6 ]. index = 6 ; i = 2; j = 4;

             while( i < arrleft.length() ) {
               returnArr[index] = arrLeft[i];   i++; index++;
             }

             while( i < arrRight.length() ) {
                returnArr[index] = arrLeft[j];   j++; index++;
             }

             Expect returnArr[1, 2, 3 , 4, 5, 6, 7, 8 ]. index = 9 ;
             return returnArr;

 */