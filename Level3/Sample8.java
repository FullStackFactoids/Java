// Necessary import for the @FunctionalInterface annotation
import java.util.function.Consumer;

@FunctionalInterface
interface MyFunctionalInterface {
    void execute();
}

public class Sample8 {
    public static void main(String[] args) {
        // Demonstrate the use of the functional interface
        MyFunctionalInterface myFunction = () -> System.out.println("Executing the functional interface method");
        myFunction.execute();

        // Another demonstration using Java's built-in functional interfaces
        Consumer<String> consumer = (message) -> System.out.println(message);
        consumer.accept("This is a message passed to a Consumer functional interface");
    }
}
