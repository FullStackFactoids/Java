public class Sample1 {
    public static void main(String[] args) {
        ImmutableClass immutableObject = new ImmutableClass(5);
        System.out.println("Value of immutable object: " + immutableObject.getValue());

        // Attempting to change the value will result in a compile-time error
        // immutableObject.value = 10;  // Uncommenting this line will cause an error
        //Fun fact
        String str = "Hello";
        str.concat(" World");
        System.out.println(str); // Output: Hello
        // Doesn't modify the original string
    }
}

final class ImmutableClass {
    private final int value;

    public ImmutableClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
