package Trader;

import javax.swing.text.AsyncBoxView;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunTransaction {

    public static void main(String... args) {
        Trader james = new Trader("James", "Cambridge");
        Trader david = new Trader("David", "Cambridge");
        Trader luke = new Trader("Luke", "Cambridge");
        Trader kate = new Trader("Kate", "Nottingham");
        Trader alan = new Trader("Alan", "London");
        Trader brian = new Trader("Brian", "Manchester");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(james, 2023, 300),
                new Transaction(james, 2023, 1000),
                new Transaction(david, 2020, 684),
                new Transaction(david, 2021, 452),
                new Transaction(luke, 2023, 520),


                new Transaction(kate, 2012, 710),
                new Transaction(kate, 2022, 700),

                new Transaction(alan, 2022, 950),

                new Transaction(brian, 2021, 400),
                new Transaction(brian, 2021, 600)
        );


        // Query 1: Find all transactions from year 2021 and sort them by value (small to high).
        List<Transaction> trans2021 = transactions.stream()
                .filter(t -> t.getYear() == 2021)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("Query 1: Find all transactions from year 2021 and sort them by value (small to high).");
        System.out.println(trans2021);


        // Query 2: What are all the unique cities where the traders work?
        String cites = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println("Query 2: What are all the unique cities where the traders work?");
        System.out.println(cites);


        // Query 3: Find all traders from Cambridge and sort them by name.
        List<Trader> traders = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Query 3: Find all traders from Cambridge and sort them by name.");
        System.out.println(traders);


        // Query 4: Return a string of all traders’ names sorted alphabetically.
        String nameOfTraderSorted = transactions.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .map(Trader::getName).collect(Collectors.joining(" , "));

        System.out.println("Query 4: Return a string of all traders’ names sorted alphabetically.");
        System.out.println(nameOfTraderSorted);


        // Query 5: Are there any trader based in Milan?
        boolean areThereAnyTraderBaseInMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("Query 5: Are there any trader based in Milan?");
        if (areThereAnyTraderBaseInMilan) {
            System.out.println("-> yes");
        } else {
            System.out.println(" -> no");
        }

        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .forEach(trader -> trader.setCity("Milan"));
        System.out.println("Query 6: Update all transactions so that the traders from Milan are set to Cambridge.");
        System.out.println(transactions);  //


        // Query 7: What's the highest value in all the transactions?
         int highestValue  = transactions.stream()
                 .max(Comparator.comparingDouble(Transaction::getValue)).get().getValue();
        System.out.println("Query 7: What's the highest value in all the transactions?");
        System.out.println(highestValue);

    }
}
