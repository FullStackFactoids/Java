import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;


public class Sample3 {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        int incrementedValue = atomicInt.incrementAndGet();
        System.out.println("Initial value: 0");
        System.out.println("After atomic increment: " + incrementedValue); // Output: 1
        //Fun Fact
        // Demonstration of LongAdder
        LongAdder adder = new LongAdder();
        adder.add(1);
        System.out.println("\nInitial value (LongAdder): 0");
        System.out.println("After addition (LongAdder): " + adder.sum());
    }
}
