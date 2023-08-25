import java.util.ArrayList;
import java.util.Vector;

public class Sample3 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> vec = new Vector<>();

        // Create a Runnable that adds elements to ArrayList and Vector
        Runnable addElements = () -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
                vec.add(i);
            }
        };

        // Start two threads that run the addElements Runnable
        Thread thread1 = new Thread(addElements);
        Thread thread2 = new Thread(addElements);
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Print the size of ArrayList and Vector
        System.out.println("Size of ArrayList: " + list.size());
        System.out.println("Size of Vector: " + vec.size());
        //In this code, we create two threads that both add
        // elements to the ArrayList and Vector. Since ArrayList is not
        // synchronized, the size of the ArrayList may not be
        // 200 as expected because the threads may interfere with each
        // other. On the other hand, since Vector is synchronized, its size will
        // always be 200 because it is thread-safe.
    }
}