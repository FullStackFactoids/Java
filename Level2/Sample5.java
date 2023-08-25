public class Sample5 {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2);
        // Output: false
        System.out.println(s1.equals(s2));
        // Output: true
    }
}

