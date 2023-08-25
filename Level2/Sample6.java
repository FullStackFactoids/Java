import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Sample6 {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("Resources have been cleaned up successfully.");
                }
            } catch (IOException ex) {
                System.out.println("An error occurred while closing the reader.");
                ex.printStackTrace();
            }
        }
    }
}