import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

public class Sample3 {
    public static void main(String[] args) {
        // Initialize the CuratorFramework client with retry policy
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                "localhost:2181", // Assuming ZooKeeper is running on localhost:2181
                new ExponentialBackoffRetry(1000, 3)
        );
        client.start();

        InterProcessMutex lock = new InterProcessMutex(client, "/lockPath");

        try {
            if (lock.acquire(1000, TimeUnit.MILLISECONDS)) {
                try {
                    // critical section
                    System.out.println("Acquired the distributed lock!");
                } finally {
                    lock.release();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }
}
// To run this code, you'll need to have a ZooKeeper instance running on localhost:2181
// (or adjust the connection string accordingly). You'll also need to include the necessary
// Curator and ZooKeeper libraries in your project.