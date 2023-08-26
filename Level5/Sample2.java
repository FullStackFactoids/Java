public class Sample2 {
    public static void main(String[] args) {
        Singleton firstInstance = Singleton.getInstance();
        System.out.println("First instance created: " + firstInstance);

        // Uncommenting the following lines will throw an exception
        // try {
        //     Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        //     constructor.setAccessible(true);
        //     Singleton secondInstance = constructor.newInstance();
        //     System.out.println("Second instance created using reflection: " + secondInstance);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

//Fun Fact
//Uncomment to test
//public class Sample2 {
//    public static void main(String[] args) {
//        Singleton singleton = Singleton.INSTANCE;
//        singleton.doSomething();
//
//        // Attempting to create another instance using reflection will fail
//        // Uncommenting the following lines will throw an exception
//        // try {
//        //     Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
//        //     constructor.setAccessible(true);
//        //     Singleton anotherInstance = constructor.newInstance();
//        //     System.out.println("Another instance created using reflection: " + anotherInstance);
//        // } catch (Exception e) {
//        //     e.printStackTrace();
//        // }
//    }
//}
//
//public enum Singleton {
//    INSTANCE;
//
//    public void doSomething() {
//        System.out.println("Singleton instance is doing something!");
//    }
//}

