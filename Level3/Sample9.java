import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Sample9 {
    public static void main(String[] args) {
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() ->
                System.out.println("Running"), 0, 10, TimeUnit.SECONDS);  // 1
    }

}