public class Sample5 {

    public void show () {
        int x = 10; // x is a local variable
        System.out.println(x); // Output: 10
    }
    public static void main(String[] args) {
        Sample5 sample = new Sample5(); // Create an instance of Sample5
        sample.show(); // Call the show() method
    }
}