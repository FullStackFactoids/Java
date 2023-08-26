import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sample6 {
    public static void main(String[] args) {
        // Using CompletableFuture
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() -> "Hello")
                        .thenApplyAsync(s -> s + " World")
                        .thenApplyAsync(s -> s + ", Welcome to CompletableFuture!");

        completableFuture.thenAccept(result -> {
            System.out.println("CompletableFuture Result: " + result);
        });

        // Using Future (lacks advanced combinatory operations)
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
            return "Hello from Future!";
        });

        try {
            System.out.println("Future Result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Fun Fact
        // Demonstrating reactive programming with CompletableFuture
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Result from Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "Result from Future 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            return "Result from Future 3";
        });

        CompletableFuture<Void> combined = CompletableFuture.allOf(future1, future2, future3);
        combined.thenRun(() -> {
            try {
                System.out.println(future1.get());
                System.out.println(future2.get());
                System.out.println(future3.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
