package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class SearchArray {

    public static void main(String... args) throws IOException {

        int[] arrayInt = new int[]{1 ,3 , 6, 7, 10, 23, 50, 77, 100} ;
        findNumberX(61, arrayInt, 0, arrayInt.length-1);
        // O(log n)
    }

    private static boolean findNumberX(int x, int [] arrayInt, int start, int end) {

        if(start > end ){
            return false;
        }
        int mid =  Math.round((end + start) /2) ; // 4
        if(arrayInt[mid] == x){
            return true;
        }else if (arrayInt[mid] > x){
            findNumberX(x, arrayInt, start, mid-1);
        }else  if(arrayInt[mid] < x){
            findNumberX(x, arrayInt, mid+1, end);
        }
        return false;
    }
}

