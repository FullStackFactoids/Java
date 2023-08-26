public class Sample8 {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = "Hello";
        String str3 = str1.intern();

        System.out.println(str1 == str2);  // false
        System.out.println(str2 == str3);  // true
    }
}