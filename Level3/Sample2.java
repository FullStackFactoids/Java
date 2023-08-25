import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;


//CyclicBarrier ensures that all threads wait until all of them reach the barrier point, and then they all proceed together.
//CountDownLatch allows one or more threads to wait until a set of operations being performed in other threads completes.
public class Sample2 {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All parties have reached the barrier!");
        });

        CountDownLatch latch = new CountDownLatch(3);

        // Example usage of CyclicBarrier
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                // Example usage of CountDownLatch
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " has decreased the latch count");
            }).start();
        }

        try {
            latch.await();
            System.out.println("All threads have finished execution");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
