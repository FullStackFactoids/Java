public class Sample10 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("Singleton instance created: " + instance);
    }
}

class Singleton {
    private Singleton() {
        // private constructor to prevent direct instantiation
    }

    // Inner static class responsible for holding Singleton instance
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
