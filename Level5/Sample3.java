public class Sample3 {
    public static void main(String[] args) {
        try {
            // Loading the class without triggering its static initializers
            Class<?> clazz = Class.forName("MyClass", false, Sample3.class.getClassLoader());
            System.out.println("Class loaded without initializing static blocks!");

            // Uncommenting the following line will trigger the static initializer
            // Object obj = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } /*catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }*/
    }
}

class MyClass {
    static {
        System.out.println("Static initializer block of MyClass triggered!");
    }

    public MyClass() {
        System.out.println("Constructor of MyClass called!");
    }
}
