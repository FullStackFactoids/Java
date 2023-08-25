public class Sample7 {
    public static void main(String[] args) {
        // Demonstrate the lazy initialization using the Holder pattern
        LazyInitializationExample instance = LazyInitializationExample.getInstance();
        System.out.println("Instance created: " + instance);

        //Fun Fact
        // Demonstrate the Double-Checked Locking pattern
        Singleton instance1 = Singleton.getInstance();
        System.out.println("Instance created: " + instance1);

        Singleton instance2 = Singleton.getInstance();
        System.out.println("Instance retrieved: " + instance2);
    }
}


class LazyInitializationExample {
    // Private constructor to prevent direct instantiation
    private LazyInitializationExample() {
        System.out.println("LazyInitializationExample instance created");
    }

    // Static inner class to hold the instance of the object
    private static class LazyHolder {
        private static final LazyInitializationExample INSTANCE =
                new LazyInitializationExample();
    }

    // Public method to provide access to the instance
    public static LazyInitializationExample getInstance() {
        return LazyHolder.INSTANCE;
    }
}


//Fun Fact
class Singleton {
    // Using volatile keyword for the instance
    private static volatile Singleton instance;

    // Private constructor to prevent direct instantiation
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    // Using Double-Checked Locking with volatile to achieve lazy initialization
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}





