import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Sample2 {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Create 1000 threads, each incrementing the atomicInt by 1
        IntStream.range(0, 1000).parallel().forEach(i -> atomicInt.incrementAndGet());

        System.out.println("Final Value: " + atomicInt.get());  // Expected Output: 1000
    }
}
