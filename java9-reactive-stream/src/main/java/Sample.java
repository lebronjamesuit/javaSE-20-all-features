import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Sample {

    public static void main(String... args) {

        List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14);

        num.stream()
                .map(e -> e* 2)
                .forEach(System.out::println);

        // Reactive


        SubmissionPublisher<Integer> submissionPublisher = new SubmissionPublisher<>();
        submissionPublisher.subscribe(new Flow.Subscriber<Integer>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(5);  // I tell the publisher my capacity is 5

            }

            @Override
            public void onNext(Integer item) {
                System.out.println("Number is : "+ item * 2); // Action with that number
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(" Happen error" + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Done");

            }
        });

        for (Integer i : num) {
             submissionPublisher.submit(i);
        }
    }
}
