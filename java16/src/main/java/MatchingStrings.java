
import java.util.*;
import static java.util.stream.Collectors.toList;

public class MatchingStrings {

    public static void main(String[] args){

        List<String> str = Arrays.asList("aba","baba","aba","xzxb");
        List<String> query = Arrays.asList("aba","xzxb","ab");
        matchingStrings(str, query);
        System.out.println( matchingStrings(str, query));
    }


    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here

        List<Long> listLong = queries.stream().map(  i -> strings.stream().filter(str -> str.equals(i)).count() ).toList();

        // Java 11
        /*return  listLong.stream().map( l -> {
            return l.intValue();
        }).collect(toList());*/

        // Java 16
        return  listLong.stream().map( l -> {
            return l.intValue();
        }).toList();

    }

   // Stream.toList() is only available since java16
}
