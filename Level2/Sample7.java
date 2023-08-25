import java.util.Random;

public final class Sample7 {
    private final int value;

    public Sample7() {
        Random random = new Random();
        this.value = random.nextInt();
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Sample7 immutableClass = new Sample7();
        System.out.println("Random value: " + immutableClass.getValue()); // Output: Random value: -1157793070
    }
}