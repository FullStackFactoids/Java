import java.util.concurrent.*;

public class Sample4 {
    public static void main(String[] args) {
        int corePoolSize = 5;  // Number of threads to keep in the pool, even if they are idle
        int maxPoolSize = 10;  // Maximum number of threads to allow in the pool
        long keepAliveTime = 5000;  // Time an idle thread waits before terminating
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();  // Work queue to hold tasks before they are executed

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                workQueue
        );

        threadPool.submit(() -> {
            System.out.println("Executing Task 1 by thread: " + Thread.currentThread().getName());
        });

        threadPool.submit(() -> {
            System.out.println("Executing Task 2 by thread: " + Thread.currentThread().getName());
        });

        threadPool.shutdown();  // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted
    }
}
