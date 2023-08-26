import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Sample5 {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("test.txt", "data.txt");

        data.forEach(file -> {
            try {
                Files.readAllLines(Paths.get(file)).forEach(System.out::println);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });

        //Fun Fact
        try {
            Files.list(Paths.get("/path/to/directory"))//Replace /path/to/directory with a valid directory path on your system containing some text files.
                    .forEach(path -> {
                        try {
                            System.out.println(Files.readAllLines(path));
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        } catch (UncheckedIOException e) {
            System.out.println("Caught wrapped IOException: " + e.getCause());
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e);
        }
    }
}
