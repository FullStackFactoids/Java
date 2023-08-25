import java.io.*;

class SampleObject implements Serializable {
    int normalData = 5;
    transient int tempData = 10; // This won't be serialized
}

public class Sample1 {
    public static void main(String[] args) {
        SampleObject myObject = new SampleObject();

        // Serializing myObject
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"))) {
            out.writeObject(myObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

        myObject = null;

        // Deserializing myObject
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"))) {
            myObject = (SampleObject) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (myObject != null) {
            System.out.println("normalData after deserialization: " + myObject.normalData);
            System.out.println("tempData after deserialization: " + myObject.tempData);
        }
    }
}