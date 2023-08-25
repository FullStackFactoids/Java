import java.util.Arrays;
import java.util.List;
public class Sample4 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().forEach(System.out::println);
        // Sequential
        list.parallelStream().forEach(System.out::println);
        // Parallel
        list.parallelStream().forEachOrdered(System.out::println);

    }
}