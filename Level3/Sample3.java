import java.util.Optional;

public class Sample3 {
    public static void main(String[] args) {

        // Create an Optional with a null value
        Optional<String> optional = Optional.ofNullable(null);

        // Use ifPresent to print the value if it's present (it won't do anything in this case since the value is null)
        optional.ifPresent(System.out::println);

        // Use ifPresentOrElse to print the value if it's present, or a default message if it's absent
        optional.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Value is absent")
        );
    }
}
