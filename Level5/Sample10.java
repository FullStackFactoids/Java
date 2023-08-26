import java.io.*;

public class Sample10 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            oos.writeObject(instance1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        Singleton instance2 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            instance2 = (Singleton) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Check if both instances are the same
        System.out.println("Are both instances the same? " + (instance1 == instance2));
    }
}

class Singleton implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        // private constructor
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
