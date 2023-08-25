public class Sample2 {
    public static void main(String[] args) {

        // Instantiate Singleton class
        Singleton singletonInstance = Singleton.getInstance();
        System.out.println(singletonInstance); // Output: Singleton@15db9742

        // Instantiate Singleton class again
        Singleton anotherSingletonInstance = Singleton.getInstance();
        System.out.println(anotherSingletonInstance); // Output: Singleton@15db9742

        // Check if both instances are the same
        if (singletonInstance == anotherSingletonInstance) {
            System.out.println("Both instances are the same, demonstrating that the Singleton pattern restricts a class from instantiating multiple objects.");
        } else {
            System.out.println("The instances are not the same, which should not happen with the Singleton pattern.");
        }
    }
}

class Singleton {
    private static volatile Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}