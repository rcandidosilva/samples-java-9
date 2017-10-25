package samples;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

class MySubscriber implements Flow.Subscriber<Integer> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
    }

    @Override
    public void onComplete() {
    }
}


public class ReactiveStreams {

    public static void main(String[] args) throws Exception {

        SubmissionPublisher<Integer> publisher =
                new SubmissionPublisher<>();

        MySubscriber mySubscriber = new MySubscriber();
        publisher.subscribe(mySubscriber);

        IntStream.of(1, 2, 3, 4, 5).forEach(publisher::submit);

        Thread.sleep(10000);
    }

}
