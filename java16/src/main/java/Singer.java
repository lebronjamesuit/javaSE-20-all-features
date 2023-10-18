import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Singer {



    public static int countFavouriteSingers(int [] arrNum ) {

        HashMap<Integer, Integer> hashMap = new HashMap();
        // I want hashMap has value:  3 3 2 2 1 -> map<3, 2> ; <2, 2> ; <1, 1>

        for (int num: arrNum) {
            // If appear -> increase 1 , if not, show 0
            int increaseUnit =  hashMap.getOrDefault(num, Integer.valueOf(0)) + 1;
            hashMap.put(num, increaseUnit);
        }

       // I want a list of these value
        List<Integer> listAppearTime = new ArrayList<>(hashMap.values());

        // We got  1 2 1 1 2
        // 3. How to count appear time of the maximum number
            // 3.1 Find the maximum number: it's 2
                // 3.1.2  sort the list  -> 1  1 1 2 2
                // 3.1.3  the last number is the max :  list.get(size-1);

        listAppearTime.sort(Comparator.naturalOrder());
        int max = listAppearTime.get(listAppearTime.size()-1);


            // 3.2 Count appear time of it.
                // 3.2.1:  loop over the list, and increase countAppear var by 1
                //  1 1 1 2 2

        int countAppearTime  = 1;
        for (int i = listAppearTime.size()-1; i >= 0; i--) {
            if(listAppearTime.get(i) == listAppearTime.get(i-1)){
                countAppearTime += 1;
            }else{
                break;
            }
        }

        return countAppearTime;

    }

    public static void main(String... args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String [] numberOfSongs  =  bufferedReader.readLine().split(" ");
        int [] idOfSinger =  Arrays.stream(numberOfSongs).limit(n).mapToInt(a -> Integer.valueOf(a)).toArray();

        int result = Singer.countFavouriteSingers(idOfSinger);
        bufferedReader.close();
        System.out.println(result);

    }

}
