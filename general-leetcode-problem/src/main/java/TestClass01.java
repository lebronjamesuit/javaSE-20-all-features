import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


// Silly way to implement, native way
public class TestClass01 {

    public static void main(String args[] ) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String [] numberOfSongs  =  bufferedReader.readLine().split(" ");
        int [] idOfSinger =  Arrays.stream(numberOfSongs).limit(n).mapToInt(a -> Integer.valueOf(a)).toArray();

        int result = TestClass01.countFavouriteSingers(n, idOfSinger);
        bufferedReader.close();
        System.out.println(result);

    }

    public static int countFavouriteSingers(int n, int [] arrNum ) {
        // Write your code here
        List<Integer> listInt = Arrays.stream(arrNum).boxed().sorted().toList();

        List<Integer> listOfDup = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < listInt.size() -1 ; i++) {
            if(listInt.get(i) == listInt.get(i + 1)){
                count += 1;
                // Case last item
                if(i == listInt.size() - 2){
                    listOfDup.add(count);
                }
            } else {
                listOfDup.add(count);
                // reset count
                count = 1;
            }
        }
        //  List<Integer> listInt =  { 2, 1 ,3 ,3 }
        listOfDup.sort(Comparator.naturalOrder());
        // Expect List<Integer> listInt =  { 1, 2 ,3 ,3 }
        int resultSingerCount = 1 ;
        for (int i = listOfDup.size() -1; i > 0  ; i--) {
            if(listOfDup.get(i) == listOfDup.get(i-1))
                resultSingerCount += 1 ;
            else break ;
        }
        return resultSingerCount;
    }

}
