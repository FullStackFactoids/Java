import reactor.core.publisher.Flux;
import io.reactivex.rxjava3.core.Observable;

public class Sample6 {
    public static void main(String[] args) {
        // Using Project Reactor
        Flux<String> flux = Flux.just("A", "B", "C");
        flux.subscribe(item -> System.out.println("Reactor: " + item));

        // Using RxJava
        Observable<String> observable = Observable.just("A", "B", "C");
        observable.subscribe(item -> System.out.println("RxJava: " + item));
    }
}
