import java.io.*;

public class Sample9 implements Serializable {
    private transient String nonSerializedField;

    public static void main(String[] args) {
        Sample9 sample = new Sample9();
        sample.nonSerializedField = "This won't be serialized";

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sample9.ser"))) {
            oos.writeObject(sample);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sample9.ser"))) {
            Sample9 deserializedSample = (Sample9) ois.readObject();
            System.out.println("Deserialized field value: " + deserializedSample.nonSerializedField);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        // custom serialization code can be added here
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // custom deserialization code can be added here
    }
}
